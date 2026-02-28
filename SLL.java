/**
 * A generic singly linked list (SLL) implementation in Java.
 *
 * @param <T> the type of elements stored in this list
 */
public class SLL<T> {

    /** Inner class representing a node in the linked list */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // Head of the list
    private int size;     // Number of elements in the list

    /**
     * Constructs an empty singly linked list.
     */
    public SLL() {
        head = null;
        size = 0;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param data the element to add
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Inserts an element at a specific index.
     *
     * @param index the position to insert the element at (0-based)
     * @param data the element to insert
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     */
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    /**
     * Removes the element at a specific index.
     *
     * @param index the position of the element to remove (0-based)
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> removed;
        if (index == 0) {
            removed = head;
            head = head.next;
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            removed = prev.next;
            prev.next = removed.next;
        }
        size--;
        return removed.data;
    }

    /**
     * Returns the element at a specific index.
     *
     * @param index the position of the element to retrieve (0-based)
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
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
     * Returns true if the list is empty.
     *
     * @return true if size == 0, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string in the format [elem1, elem2, ...]
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}