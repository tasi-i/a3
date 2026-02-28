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

    /** Constructs an empty singly linked list. */
    public SLL() {
        head = null;
        size = 0;
    }

    /** Adds an element to the end of the list. */
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

    /** Inserts an element at a specific index. */
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

    /** Removes the element at a specific index and returns it. */
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

    /** Returns the element at a specific index. */
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

    /** Returns the number of elements in the list. */
    public int size() {
        return size;
    }

    /** Returns true if the list is empty. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns a string representation of the list in [elem1, elem2, ...] format. */
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

    /** Main method for quick testing */
    public static void main(String[] args) {
        SLL<Integer> list = new SLL<>();
        list.add(10);
        list.add(20);
        list.add(1, 15); // Insert 15 at index 1
        System.out.println(list); // [10, 15, 20]

        list.remove(1); 
        System.out.println(list); // [10, 20]

        System.out.println("Element at index 1: " + list.get(1)); // 20
        System.out.println("Size: " + list.size()); // 2
        System.out.println("Is empty? " + list.isEmpty()); // false
    }
}