/**
 * Your implementation of a Stack backed by an array.
 *
 * @author Bang Pham
 * @version 1.0
 */
public class ArrayStack<T> implements StackInterface<T> {

    // DO NOT ALTER OR ADD INSTANCE VARIABLES
    private T[] backingArray;
    private int size;

    /**
     * Constructs a Stack with an initial capacity of {@code INITIAL_CAPACITY}.
     * You must use constructor chaining to implement this constructor.
     */
    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }


    /**
     * Constructs a Stack with the specified initial capacity of
     * {@code initialCapacity}.
     * @param initialCapacity the initial capacity of the backing array
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        backingArray = (T[]) new Object[initialCapacity];
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
            throw new IllegalArgumentException("data is null.");
        }
        if (size == backingArray.length) {
            resize();
        }
        backingArray[size] = data;
        size++;
    }
    
    /**
     * Helper method to double the size of the backing
     * Array.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] temp = (T[]) new Object[backingArray.length * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = backingArray[i];
        }
        backingArray = temp;
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
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        T temp = backingArray[size - 1];
        backingArray[size - 1] = null;
        size--;
        return temp;
    }

    /**
     * Returns the size of the stack as an integer.
     * This method should be implemented in O(1) time.
     * @return the number of items in the stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Return true if empty, false otherwise.
     * This method should be implemented in O(1) time.
     * @return boolean representing whether the list is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    // DO NOT ALTER OR USE ANYTHING BEYOND THIS POINT!


    /**
     * Used for testing and grading purposes.
     * DO NOT USE THIS METHOD IN YOUR IMPLEMENTATION!
     *
     * @return the backing array of this stack
     */
    public Object[] getBackingArray() {
        return backingArray;
    }
}