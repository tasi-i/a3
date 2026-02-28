import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A dynamically resizing array-backed list.
 *
 * @param <T> element type
 */
public class DynamicArray<T> implements ListADT<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public DynamicArray() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
    }

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

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int capacity) {
        if (capacity <= data.length)
            return;

        int newCap = Math.max(capacity, data.length * 2);
        T[] newArr = (T[]) new Object[newCap];
        System.arraycopy(data, 0, newArr, 0, size);
        data = newArr;
    }

    @Override
    public T get(int index) {
        checkIndexExclusive(index);
        return data[index];
    }

    @Override
    public void add(int index, T element) {
        checkIndexInclusive(index);
        ensureCapacity(size + 1);

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndexExclusive(index);

        T removed = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        data[size] = null;
        return removed;
    }

    @Override
    public DynamicArray<T> splitCopy(int index) {
        checkIndexInclusive(index);

        DynamicArray<T> result = new DynamicArray<>();
        for (int i = index; i < size; i++) {
            result.add(result.size, data[i]);
        }
        return result;
    }

    @Override
    public DynamicArray<T> splitTransfer(int index) {
        checkIndexInclusive(index);

        DynamicArray<T> result = new DynamicArray<>();

        for (int i = index; i < size; i++) {
            result.add(result.size, data[i]);
        }

        for (int i = index; i < size; i++) {
            data[i] = null;
        }

        size = index;
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new DynamicArrayIterator();
    }

    /**
     * Iterator walking array by index.
     */
    private class DynamicArrayIterator implements Iterator<T> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return data[currentIndex++];
        }
    }
}