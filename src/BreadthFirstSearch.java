import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, V start) {
        super(start);
        bfs(graph, start);
    }

    private void bfs(WeightedGraph<V> graph, V rootData) {
        Queue<V> queue = new LinkedList<>();
        marked.add(rootData);
        queue.add(rootData);

        while (!queue.isEmpty()) {
            V v = queue.poll();
            Vertex<V> vertex = graph.getVertex(v);
            for (Vertex<V> w : vertex.getAdjacentVertices().keySet()) {
                if (!marked.contains(w.getData())) {
                    edgeTo.put(w.getData(), v);
                    marked.add(w.getData());
                    queue.add(w.getData());
                }
            }
        }
    }
}