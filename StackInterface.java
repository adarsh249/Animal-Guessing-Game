package TreePackage;

import java.util.EmptyStackException;

public interface StackInterface<T>
{
    /**
     * Adds a new entry to the top of this stack
     * @param anEntry The object to add to the stack
     */
    void push(T anEntry);

    /**
     * Removes and returns this stack's top entry
     * @return The object currently at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    T pop();

    /**
     * Retrieves this stack's top entry but does NOT remove it
     * @return The object currently at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    T peek();

    /**
     * Detects whether this stack is empty
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Removes all entries from the stack
     */
    void clear();
}
