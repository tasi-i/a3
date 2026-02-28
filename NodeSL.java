/**
 * A node class for singly linked lists.
 * @param <T> the type of element stored in the node
 */
public class NodeSL<T> {
    public T data;
    public NodeSL<T> next;

    /**
     * Constructs a node with the given data.
     * @param data the data to store in this node
     */
    public NodeSL(T data) {
        this.data = data;
        this.next = null;
    }
}
