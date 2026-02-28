import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic singly linked list implementation.
 *
 * @param <T> the type of elements stored in the list
 */
public class SLL<T> implements Iterable<T> {

    private NodeSL<T> head;
    private int size;

    /**
     * Constructs an empty singly linked list.
     */
    public SLL() {
        head = null;
        size = 0;
    }

    /**
     * Returns the head node of the list.
     *
     * @return the first node in the list, or null if empty
     */
    public NodeSL<T> getHead() {
        return head;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param data the element to add
     */
    public void addLast(T data) {
        NodeSL<T> newNode = new NodeSL<>(data, null);

        if (head == null) {
            head = newNode;
        } else {
            NodeSL<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    /**
     * Inserts a new element after a given node.
     *
     * @param node the node after which the new element is inserted
     * @param data the element to insert
     */
    public void addAfter(NodeSL<T> node, T data) {
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }

        NodeSL<T> newNode = new NodeSL<>(data, node.getNext());
        node.setNext(newNode);
        size++;
    }

    /**
     * Removes the node immediately following the given node.
     *
     * @param node the node before the one to remove
     * @return the data of the removed node
     */
    public T removeAfter(NodeSL<T> node) {
        if (node == null || node.getNext() == null) {
            throw new IllegalArgumentException("No node exists after the given node");
        }

        NodeSL<T> toRemove = node.getNext();
        node.setNext(toRemove.getNext());
        size--;

        return toRemove.getData();
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements in this list.
     *
     * @return an iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private NodeSL<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }
}