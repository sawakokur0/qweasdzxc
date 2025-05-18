import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<V, Double> distTo = new HashMap<>();

    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        super(start);
        dijkstra(graph, start);
    }

    private void dijkstra(WeightedGraph<V> graph, V sourceData) {
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(v -> distTo.get(v.getData())));
        Vertex<V> source = graph.getVertex(sourceData);

        for (Vertex<V> v : graph.getVertices()) {
            distTo.put(v.getData(), Double.POSITIVE_INFINITY);
        }
        distTo.put(sourceData, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();
            V currentData = current.getData();
            marked.add(currentData);

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                V neighborData = neighbor.getData();
                double weight = entry.getValue();

                if (distTo.get(currentData) + weight < distTo.get(neighborData)) {
                    distTo.put(neighborData, distTo.get(currentData) + weight);
                    edgeTo.put(neighborData, currentData);
                    pq.remove(neighbor);
                    pq.add(neighbor);
                }
            }
        }
    }

    public double getDistanceTo(V v) {
        return distTo.getOrDefault(v, Double.POSITIVE_INFINITY);
    }
}