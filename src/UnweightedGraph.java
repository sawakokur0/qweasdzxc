public class UnweightedGraph<V> extends WeightedGraph<V> {
    public UnweightedGraph(boolean directed) {
        super(directed);
    }

    public void addEdge(V source, V destination) {
        super.addEdge(source, destination, 1.0);
    }
}