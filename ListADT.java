import java.util.Iterator;

/**
 * A simple generic List ADT interface.
 *
 * @param <T> element type stored in the list
 */
public interface ListADT<T> extends Iterable<T> {

    /**
     * Returns the number of elements in the list.
     *
     * @return current size
     */
    int size();

    /**
     * Returns the element at a given index.
     *
     * @param index position to access
     * @return element at index
     * @throws IndexOutOfBoundsException if index invalid
     */
    T get(int index);

    /**
     * Inserts element at given index.
     *
     * @param index position to insert
     * @param element element to insert
     * @throws IndexOutOfBoundsException if index invalid
     */
    void add(int index, T element);

    /**
     * Removes and returns element at index.
     *
     * @param index position to remove
     * @return removed element
     * @throws IndexOutOfBoundsException if index invalid
     */
    T remove(int index);

    /**
     * Copy-style split.
     *
     * @param index split index
     * @return new list containing elements index..size-1
     * @throws IndexOutOfBoundsException if index invalid
     */
    ListADT<T> splitCopy(int index);

    /**
     * Transfer-style split.
     *
     * @param index split index
     * @return new list containing elements index..size-1
     * @throws IndexOutOfBoundsException if index invalid
     */
    ListADT<T> splitTransfer(int index);

    /**
     * Returns an iterator over elements in list order.
     *
     * @return fresh iterator starting at beginning
     */
    @Override
    Iterator<T> iterator();
}