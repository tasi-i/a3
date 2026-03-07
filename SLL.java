import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A singly-linked list implementation.
 *
 * @param <T> the type of elements stored in the list
 */
public class SLL<T> implements ListADT<T>, Iterable<T> {

    private NodeSL<T> head;
    private int size;

    private static class NodeSL<T> {
        private T data;
        private NodeSL<T> next;
        NodeSL(T data, NodeSL<T> next) { this.data = data; this.next = next; }
    }

    public SLL() { head = null; size = 0; }

    @Override public int size() { return size; }
    @Override public boolean isEmpty() { return size == 0; }

    @Override
    public T get(int index) { checkIndexExclusive(index); return getNode(index).data; }

    @Override
    public T set(int index, T element) {
        checkIndexExclusive(index);
        NodeSL<T> node = getNode(index);
        T old = node.data;
        node.data = element;
        return old;
    }

    @Override
    public void add(int index, T element) {
        checkIndexInclusive(index);
        NodeSL<T> newNode = new NodeSL<>(element, null);
        if (index == 0) { newNode.next = head; head = newNode; }
        else {
            NodeSL<T> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndexExclusive(index);
        T removed;
        if (index == 0) { removed = head.data; head = head.next; }
        else {
            NodeSL<T> prev = getNode(index - 1);
            removed = prev.next.data;
            prev.next = prev.next.next;
        }
        size--;
        return removed;
    }

    public SLL<T> splitCopy(int index) {
        checkIndexInclusive(index);
        SLL<T> result = new SLL<>();
        NodeSL<T> current = (index == size) ? null : getNode(index);
        while (current != null) { result.add(result.size, current.data); current = current.next; }
        return result;
    }

    public SLL<T> splitTransfer(int index) {
        checkIndexInclusive(index);
        SLL<T> result = new SLL<>();
        if (index == size) return result;
        if (index == 0) { result.head = head; result.size = size; head = null; size = 0; return result; }
        NodeSL<T> prev = getNode(index - 1);
        result.head = prev.next;
        result.size = size - index;
        prev.next = null;
        size = index;
        return result;
    }

    @Override public Iterator<T> iterator() { return new SLLIterator(); }

    private NodeSL<T> getNode(int index) {
        checkIndexExclusive(index);
        NodeSL<T> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
    }

    private void checkIndexExclusive(int index) { if (index < 0 || index >= size) throw new IndexOutOfBoundsException(); }
    private void checkIndexInclusive(int index) { if (index < 0 || index > size) throw new IndexOutOfBoundsException(); }

    private class SLLIterator implements Iterator<T> {
        private NodeSL<T> current = head;
        @Override public boolean hasNext() { return current != null; }
        @Override public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T val = current.data;
            current = current.next;
            return val;
        }
    }
}