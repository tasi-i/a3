/**
 * A ListADT represents an ordered, resizable sequence of elements.
 * Elements are arranged by position and numbered starting at 0.
 *
 * @param <E> type of elements stored in the list
 */
public interface ListADT<E> {

    /**
     * Returns number of elements in the list.
     *
     * @return size of the list
     */
    int size();

    /**
     * Returns true if the list contains no elements.
     *
     * @return true if empty
     */
    boolean isEmpty();

    /**
     * Returns element at index.
     *
     * @param index position of element
     * @return element at index
     */
    E get(int index);

    /**
     * Replaces element at index.
     *
     * @param index index to replace
     * @param element new element
     * @return old element
     */
    E set(int index, E element);

    /**
     * Inserts element at index.
     *
     * @param index position
     * @param element element to insert
     */
    void add(int index, E element);

    /**
     * Removes element at index.
     *
     * @param index index to remove
     * @return removed element
     */
    E remove(int index);
}