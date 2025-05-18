import java.util.*;

public class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(WeightedGraph<V> graph, V start) {
        super(start);
        dfs(graph, start);
    }

    private void dfs(WeightedGraph<V> graph, V current) {
        marked.add(current);
        Vertex<V> vertex = graph.getVertex(current);
        for (Vertex<V> neighbor : vertex.getAdjacentVertices().keySet()) {
            V next = neighbor.getData();
            if (!marked.contains(next)) {
                edgeTo.put(next, current);
                dfs(graph, next);
            }
        }
    }
}