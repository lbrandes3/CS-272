// Luke Brandes
// Interface to use for queues

public interface QueueInterface<E> {
    boolean enqueue(E e);
    E dequeue();
    E front();
    int size();
    boolean isEmpty();
}
