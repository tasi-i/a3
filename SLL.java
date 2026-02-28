import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Singly Linked List implementation supporting iteration and split operations.
 *
 * @param <T> the type of elements stored in the list
 */
public class SLL<T> implements Iterable<T> {

    /**
     * Node class representing each element in the linked list.
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // first node of the list
    private int size;     // number of elements in the list

    /**
     * Constructs an empty singly linked list.
     */
    public SLL() {
        head = null;
        size = 0;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list has no elements, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param value the element to add
     */
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
        size++;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index position of the element to retrieve
     * @return the element at the given index
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public T get(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.data;
    }

    /**
     * Checks whether an index is valid for this list.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException if index is invalid
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    // -----------------------------
    // ITERATOR IMPLEMENTATION
    // -----------------------------

    /**
     * Returns a fresh iterator over the elements of this list in proper sequence.
     *
     * @return a node-based iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new SLLIterator();
    }

    /**
     * Private iterator class for SLL.
     * Traverses nodes in order without modifying the list.
     */
    private class SLLIterator implements Iterator<T> {
        private Node<T> current = head;

        /**
         * Checks if there is a next element.
         *
         * @return true if more elements exist, false otherwise
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element
         * @throws NoSuchElementException if no more elements exist
         */
        @Override
        public T next() {
            if (current == null)
                throw new NoSuchElementException();
            T value = current.data;
            current = current.next;
            return value;
        }
    }

    // -----------------------------
    // SPLIT METHODS
    // -----------------------------

    /**
     * Creates a new list containing a copy of elements from the specified index to the end.
     * Original list remains unchanged.
     *
     * @param index the index at which to split
     * @return a new list containing the tail elements
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public SLL<T> splitCopy(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        SLL<T> newList = new SLL<>();
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // skip prefix
        }
        while (current != null) {
            newList.add(current.data);
            current = current.next;
        }
        return newList;
    }

    /**
     * Transfers elements from the specified index to the end into a new list.
     * Original list is truncated to elements before the index.
     *
     * @param index the index at which to split
     * @return a new list containing the tail elements
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public SLL<T> splitTransfer(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        SLL<T> newList = new SLL<>();
        if (index == 0) { // transfer everything
            newList.head = head;
            newList.size = size;
            head = null;
            size = 0;
            return newList;
        }
        if (index == size) { // nothing to transfer
            return newList;
        }

        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        newList.head = current.next;
        newList.size = size - index;
        current.next = null; // detach tail
        size = index;

        return newList;
    }
}