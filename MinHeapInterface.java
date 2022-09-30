package TreePackage;

public interface MinHeapInterface<T> 
{
    /**
     * Adds a new entry to this heap.
     * @param newEntry The object to be added.
     */
    void add(T newEntry);
    
    /**
     * Removes and returns the smalelst item in the heap
     * @return The smallest object in heap or null if heap is empty
     */
    T removeMin();

    /**
     * Returns the smalelst item in the heap
     * @return The smallest object in heap or null if heap is empty
     */
    T getMin();

    /**
     * Determines whether the heap is empty
     * @return True if heap is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Gets the size of this heap
     * @return The number of entries currently in the heap
     */
    int getSize();

    /**
     * Removes all entries from the heap
     */
    void clear();
}
