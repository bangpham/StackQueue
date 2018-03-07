/**
 * Your implementation of a Stack backed by a LinkedList.
 *
 * @author Bang Pham
 * @version 1.0
 */
public class LinkedListStack<T> implements StackInterface<T> {

    // DO NOT ALTER OR ADD INSTANCE VARIABLES
    private LinkedListInterface<T> backingList;

    /**
     * Constructs an empty Stack.
     */
    public LinkedListStack() {
        backingList = new DoublyLinkedList<T>();
    }

    /**
     * Pushes a node with the given data onto the stack.
     * This method should be implemented in O(1) time for the linked list-backed
     * implementation and amortized O(1) time for the array-backed
     * implementation.
     * For the array-backed implementations, if the array is completely filled
     * when trying to push, double the size of the array first before adding.
     * @param data the data to push
     * @throws IllegalArgumentException if {@code data} is null
     */
    @Override
    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data is null");
        }
        backingList.add(data);
    }

    /**
     * Pops an item from the stack.
     * This method should be implemented in O(1) time.
     * For array-backed implementations:
     * - you should not shrink the backing array.
     * - you must put {@code null} in the popped element's slot.
     * @return the data from the top of the stack
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    @Override
    public T pop() {
        if (backingList.isEmpty()) {
            throw new java.util.NoSuchElementException("Stack is empty.");
        }
        return backingList.remove();
    }

    /**
     * Returns the size of the stack as an integer.
     * This method should be implemented in O(1) time.
     * @return the number of items in the stack
     */
    @Override
    public int size() {
        return backingList.size();
    }

    /**
     * Return true if empty, false otherwise.
     * This method should be implemented in O(1) time.
     * @return boolean representing whether the list is empty
     */
    @Override
    public boolean isEmpty() {
        return backingList.isEmpty();
    }


    // DO NOT ALTER OR USE ANYTHING BEYOND THIS POINT!


    /**
     * Used for testing and grading purposes.
     * DO NOT USE THIS METHOD IN YOUR IMPLEMENTATION!
     *
     * @return the backing list of this stack
     */
    public LinkedListInterface<T> getBackingList() {
        return backingList;
    }

}