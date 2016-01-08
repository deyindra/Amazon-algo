package org.idey.algo.ds;

/**
 * @author Indranil Dey
 * Generic GraphNode Node
 */
public class GraphNode<T> {
    private T object;
    private VisitStatus status;

    public GraphNode(T object) {
        assert (object!=null);
        this.object = object;
        status = VisitStatus.UNVISITED;
    }

    public T getObject() {
        return object;
    }

    public void setVisited(){
        this.status = VisitStatus.VISITED;
    }

    public void setUnVisited(){
        this.status = VisitStatus.UNVISITED;
    }

    public VisitStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphNode<?> graphNode = (GraphNode<?>) o;

        return !(object != null ? !object.equals(graphNode.object) : graphNode.object != null);

    }

    @Override
    public int hashCode() {
        return object != null ? object.hashCode() : 0;
    }

    @Override
    public String toString() {
        return object.toString();
    }

    public enum VisitStatus{
        VISITED, UNVISITED;
    }
}
