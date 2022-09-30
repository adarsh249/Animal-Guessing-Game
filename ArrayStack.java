package TreePackage;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T>
{
    private T[] entries;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;
    private static int initialCapacity;

    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity)
    {
        initialCapacity = capacity;
        clear();
    }

    @Override
    public void push(T newEntry)
    {
        ensureCapacity();
        topIndex ++;
        entries[topIndex] = newEntry;
    }

    @Override
    public T pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        T top = entries[topIndex];
        entries[topIndex] = null;
        topIndex--;
        return top;
    }

    @Override
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return entries[topIndex];
        }
    }

    @Override
    public boolean isEmpty()
    {
        return topIndex == -1;
    }

    @Override
    public void clear()
    {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        entries = tempStack;
        topIndex = -1;
    }

    private void ensureCapacity()
    {
        if (topIndex == entries.length - 1)
        {
            // array is full. Double its size (if possible)
            int newLength = 2 * entries.length;
            checkCapacity(newLength);
            entries = Arrays.copyOf(entries, newLength);
        }
    }

    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Capacity too large: " + capacity);
        }
    }
}
    