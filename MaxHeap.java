package TreePackage;

public class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T>
{
    // Array to hold the heap entries
    private T[] heap;

    // Index of last entry
    private int lastIndex;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public MaxHeap(int initialCapacity)
    {
        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;
        else
            checkCapacity(initialCapacity);

        // Create an array one larger than capacity since index 0 will be empty
        @SuppressWarnings("unchecked")
        T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
        heap = tempHeap;
        lastIndex = 0;
    }

    /** Constructor to build a heap from an existing array
     * @param arr The array to turn into a heap */
    public MaxHeap(T[] arr)
    {
        // Call the other constructor to create an internal array of size arr.length
        this(arr.length);
        lastIndex = arr.length;

        // Copy the values from the array parameter to the internal array
        for (int i = 0; i < arr.length; i++)
        {
            heap[i + 1] = arr[i];
        }

        // Convert the internal array to a heap
        // We can ignore the nodes in the final level, since they are already heaps
        for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
        {
            reheap(rootIndex);
        }
    }

    @Override
    public void add(T newEntry)
    {
        // Find the first open index, or the next available leaf, in the heap
        int newIndex = lastIndex + 1;

        // Find the parent of the newly added leaf
        int parentIndex = newIndex / 2;
        while (parentIndex > 0 && newEntry.compareTo(heap[parentIndex]) > 0)
        {
            // Swap up!
            heap[newIndex] = heap[parentIndex];

            // Update newIndex to be the newly empty index
            newIndex = parentIndex;

            // Find the parent index of newIndex
            parentIndex = newIndex / 2;
        }
        // We are done swapping, so place the new item at newIndex
        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
    }

    @Override
    public T removeMax()
    {
        T max = null;

        if (!isEmpty())
        {
            max = heap[1];
            heap[1] = heap[lastIndex]; // Place the rightmost leaf in the root
            lastIndex--;
            reheap(1);
        }
        return max;
    }

    @Override
    public T getMax()
    {
        if (lastIndex < 1)
            return null;
        return heap[1];
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public int getSize()
    {
        return 0;
    }

    @Override
    public void clear()
    {

    }

    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Heap cannot have " + capacity + " items in it!");
    }

    private void reheap(int rootIndex)
    {
        boolean done = false;

        // orphan is the entry that needs to move down the heap
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;
        while (!done && leftChildIndex <= lastIndex)
        {
            // find the larger child of the entry in rootIndex
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = 2 * rootIndex + 1;
            if (rightChildIndex <= lastIndex && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
            {
                // Root has a right child and it is larger than the left child
                largerChildIndex = rightChildIndex;
            }

            if (orphan.compareTo(heap[largerChildIndex]) < 0)
            {
                // Orphan is less than the largest child, so swap down
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }
            else
                done = true;
        }
        heap[rootIndex] = orphan;
    }

    public void printHeap()
    {
        for (int i = 1; i <= lastIndex; i++)
        {
            System.out.print(heap[i] + " ");
        }
    }

    private void ensureCapacity()
    {
        // TODO: Double the size of the internal array if necessary
    }
}