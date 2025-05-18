import java.util.*;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices = new HashMap<>();
    private final boolean directed;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public Vertex<V> addVertex(V data) {
        return vertices.computeIfAbsent(data, Vertex::new);
    }

    public void addEdge(V source, V destination, double weight) {
        Vertex<V> src = addVertex(source);
        Vertex<V> dest = addVertex(destination);
        src.addAdjacentVertex(dest, weight);
        if (!directed) {
            dest.addAdjacentVertex(src, weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Collection<Vertex<V>> getVertices() {
        return vertices.values();
    }
}