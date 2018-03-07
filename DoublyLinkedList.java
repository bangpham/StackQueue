
/**
 * Your implementation of a DoublyLinkedList. Note the slightly different
 * time complexities from a SinglyLinkedList in the interface.
 *
 * @author Bang Pham
 * @version 1.0
 */
public class DoublyLinkedList<T> implements LinkedListInterface<T> {

    // DO NOT ALTER OR ADD INSTANCE VARIABLES
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;

    /**
     * Creates a new node with data {@code data} and adds the node to the
     * end of the Linked List.  The tail should be the new node.
     * Should be O(1).
     * @param data The data the new node should hold.
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    @Override
    public void add(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data is null.");
        }
        if (isEmpty()) {
            addToFront(data);
        } else {
            LinkedListNode<T> node = new LinkedListNode<T>(tail, data);
            tail.setNext(node);
            tail = node;
            size++;
        }
    }

    /**
     * Creates a new node with {@code data} and adds it to the front of the
     * linked list.  This new node should be the new head of the list.
     * Should be O(1).
     * @param data The data that the new node should hold.
     * @throws java.lang.IllegalArgumentException if data is null.
     */
    @Override
    public void addToFront(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data is null.");
        }
        if (isEmpty()) {
            LinkedListNode<T> node = new LinkedListNode<T>(data);
            head = node;
            tail = head;
        } else {
            LinkedListNode<T> node = new LinkedListNode<T>(data, head);
            head = node;
        }
        size++;
    }

    /**
     * Removes the last node from the Linked List and returns the data from it.
     * If the list is empty, return {@code null}.
     * Must be O(1).
     * @return The data from the last node or null if empty.
     */
    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        } 
        T temp = tail.getData();
        if (size == 1) {
            head = null;
            tail = null;
            size = 0; 
        } else {
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
            size--;
        }
        return temp;
    }

    /**
     * Removes the front node from the list and return the data from it. If the
     * list is empty, return {@code null}.
     * Must be O(1).
     * @return The data from the front node or null if empty.
     */
    @Override
    public T removeFromFront() {
        if (isEmpty()) {
            return null;
        } 
        T temp = head.getData();
        if (size == 1) {
            head = null;
            tail = null;
            size = 0; 
        } else {
            head = head.getNext();
            head.setPrev(null);
            size--;
        }
        return temp;
    }

    /**
     * Returns a boolean value representing whether the Linked List is empty.
     * Should be O(1).
     * @return True if empty. False otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the size of the Linked List as an integer.
     * Should be O(1).
     * @return The size of the list.
     */
    @Override
    public int size() {
        return size;
    }


    // DO NOT MODIFY CODE OR USE CODE BEYOND THIS POINT.


    @Override
    public LinkedListNode<T> getHead() {
        return head;
    }


    @Override
    public LinkedListNode<T> getTail() {
        return tail;
    }
}
