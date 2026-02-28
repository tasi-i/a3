import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A singly linked list implementation.
 *
 * @param <T> element type
 */
public class SLL<T> implements ListADT<T> {

    /** Node class */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private int size;

    @Override
    public int size() {
        return size;
    }

    private void checkIndexInclusive(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
    }

    private void checkIndexExclusive(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    private Node<T> nodeAt(int index) {
        Node<T> curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        return curr;
    }

    @Override
    public T get(int index) {
        checkIndexExclusive(index);
        return nodeAt(index).data;
    }

    @Override
    public void add(int index, T element) {
        checkIndexInclusive(index);

        if (index == 0) {
            Node<T> n = new Node<>(element);
            n.next = head;
            head = n;
        } else {
            Node<T> prev = nodeAt(index - 1);
            Node<T> n = new Node<>(element);
            n.next = prev.next;
            prev.next = n;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndexExclusive(index);

        Node<T> removed;
        if (index == 0) {
            removed = head;
            head = head.next;
        } else {
            Node<T> prev = nodeAt(index - 1);
            removed = prev.next;
            prev.next = removed.next;
        }
        size--;
        return removed.data;
    }

    @Override
    public SLL<T> splitCopy(int index) {
        checkIndexInclusive(index);

        SLL<T> result = new SLL<>();
        if (index == size)
            return result;

        Node<T> curr = nodeAt(index);
        while (curr != null) {
            result.add(result.size, curr.data);
            curr = curr.next;
        }
        return result;
    }

    @Override
    public SLL<T> splitTransfer(int index) {
        checkIndexInclusive(index);

        SLL<T> result = new SLL<>();

        if (index == 0) {
            result.head = head;
            result.size = size;
            head = null;
            size = 0;
            return result;
        }

        if (index == size)
            return result;

        Node<T> prev = nodeAt(index - 1);
        result.head = prev.next;
        result.size = size - index;

        prev.next = null;
        size = index;

        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new SLLIterator();
    }

    /**
     * Iterator for SLL walking node-by-node.
     */
    private class SLLIterator implements Iterator<T> {

        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();

            T data = current.data;
            current = current.next;
            return data;
        }
    }
}