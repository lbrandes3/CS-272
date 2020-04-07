// Luke Brandes
// Queue designed with linked lists

public class LinkedQueue<E> implements QueueInterface<E> {
    private SNode<E> tail;
    private SNode<E> head;
    private int size;

    // constructor
    LinkedQueue() {
        size = 0;
    }

    // adds a variable to the queue
    // e - element to add
    public boolean enqueue(E e) {
        if (size == 0) {
            head = tail = new SNode<>(e, null);
        } else {
            head = new SNode<>(e, head);
        }
        size++;
        return true;
    }

    // returns the front of the queue
    public E dequeue() {
        if (size == 0) { return null; }
        E temp = head.getData();
        head = head.getNext();
        size--;
        return temp;
    }

    // returns the front of the queue without removing it from the queue
    public E front() {
        if (size == 0) { return null; }
        return head.getData();
    }

    // returns the size of the queue
    public int size() {
        return size;
    }

    // returns whether the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }
}
