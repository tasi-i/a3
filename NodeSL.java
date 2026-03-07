/**
 * Node used for singly linked lists.
 *
 * @param <T> type stored in the node
 */
public class NodeSL<T> {

    /** Data stored in node */
    private T data;

    /** Reference to next node */
    private NodeSL<T> next;

    /**
     * Creates a node with given data.
     *
     * @param data value stored
     */
    public NodeSL(T data) {
        this(data, null);
    }

    /**
     * Creates a node with data and next reference.
     *
     * @param data value stored
     * @param next next node
     */
    public NodeSL(T data, NodeSL<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Returns node data.
     *
     * @return stored value
     */
    public T getData() {
        return data;
    }

    /**
     * Sets node data.
     *
     * @param data new value
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Returns next node.
     *
     * @return next node
     */
    public NodeSL<T> getNext() {
        return next;
    }

    /**
     * Sets next node reference.
     *
     * @param next new next node
     */
    public void setNext(NodeSL<T> next) {
        this.next = next;
    }
}