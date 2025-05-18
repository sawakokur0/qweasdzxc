import java.util.*;

public abstract class Search<V> {
    protected Map<V, V> edgeTo = new HashMap<>();
    protected Set<V> marked = new HashSet<>();
    protected final V start;

    public Search(V start) {
        this.start = start;
    }

    public boolean hasPathTo(V v) {
        return marked.contains(v);
    }

    public Iterable<V> pathTo(V v) {
        if (!hasPathTo(v)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V x = v; x != start; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(start);
        return path;
    }
}