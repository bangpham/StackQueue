/**
 * Your implementation of a Queue backed by a LinkedList.
 *
 * @author Bang Pham
 * @version 1.0
 */
public class LinkedListQueue<T> implements QueueInterface<T> {

    // DO NOT ALTER OR ADD INSTANCE VARIABLES
    private LinkedListInterface<T> backingList;

    /**
     * Constructs an empty Queue.
     */
    public LinkedListQueue() {
        backingList = new DoublyLinkedList<T>(); 
    }

    /**
     * Enqueues a node with the given data to the back of your queue.
     * For the array-backed implementations, if the array is completely filled
     * when trying to enqueue, double the size of the array first and then
     * enqueue.  When enqueuing into the doubled array, you should enqueue as if
     * enqueuing into a new Queue ie. start from index 0 again.
     * This method should be implemented in O(1) time for the linked list-backed
     * implementation and amortized O(1) time for the array-backed
     * implementation.
     * @param data the data to add
     * @throws IllegalArgumentException if {@code data} is null
     */
    @Override
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data is null.");
        }
        backingList.add(data);
    }

    /**
     * De-queues a node from the front of your queue.
     * For array-backed implementations:
     * - you should not shrink the backing array.
     * - you must put {@code null} in the de-queued element's spot.
     * Do NOT reset your {@code front} and {@code back} variables to their
     * initial values if the queue happens to become empty. In other words, for
     * the array-backed implementation, if I enqueue, dequeue, then enqueue,
     * then index 0 should be {@code null}, and index 1 should contain the
     * second enqueued item.
     * This method should be implemented in O(1) time.
     * @return the data from the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    @Override
    public T dequeue() {
        if (backingList.isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        return backingList.removeFromFront();
    }

    /**
     * Returns the size of the queue as an integer.
     * This method should be implemented in O(1) time.
     * @return number of items in the queue
     */
    @Override
    public int size() {
        return backingList.size();
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     * This method should be implemented in O(1) time.
     * @return boolean representing whether the queue is empty
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
     * @return the backing list of this queue
     */
    public LinkedListInterface<T> getBackingList() {
        return backingList;
    }

}