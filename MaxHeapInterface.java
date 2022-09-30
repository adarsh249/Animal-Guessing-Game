package TreePackage;

public interface MaxHeapInterface<T extends Comparable<? super T>> 
{
    /**
     * Adds a new entry to this heap
     * @param newEntry The object to be added
     */
    void add(T newEntry);

    /**
     * Removes and returns the largest item in this heap
     * @return Either the largest object in the heap or null (if heap is empty)
     */
    T removeMax();

    /**
     * Returns the largest item in the heap.
     * @return Either largest object in heap or null
     */
    T getMax();

    /**
     * Determines whether the heap is empty.
     * @return True if the heap is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Gets the size of this heap
     * @return The number of entries currently in the heap.
     */
    int getSize();

    /**
     * Removes all entries from this heap
     */
    void clear();
}
