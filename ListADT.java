/**
 * A ListADT represents an ordered, resizable sequence of elements.
 * Elements are arranged by position and numbered starting at 0.
 *
 * @param <E> type of elements stored in the list
 */
public interface ListADT<E> {

    /** Returns number of elements in the list. */
    int size();

    /** Returns true if the list contains no elements. */
    boolean isEmpty();

    /** Returns element at index. */
    E get(int index);

    /** Replaces element at index. Returns old element. */
    E set(int index, E element);

    /** Inserts element at index. */
    void add(int index, E element);

    /** Removes element at index. Returns removed element. */
    E remove(int index);
}