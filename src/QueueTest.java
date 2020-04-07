// Luke Brandes
// tests the LinkedQueue queue structure

public class QueueTest {
    public static void main(String[] args) {
        LinkedQueue<String> queueOne = new LinkedQueue<>();
        System.out.println(queueOne.dequeue());
        System.out.println(queueOne.front());
        System.out.println(queueOne.size());
        System.out.println(queueOne.isEmpty());
        queueOne.enqueue("one");
        queueOne.enqueue("two");
        queueOne.enqueue("three");
        System.out.println(queueOne.size());
        System.out.println(queueOne.dequeue());
        System.out.println(queueOne.front());
        System.out.println(queueOne.size());
        System.out.println(queueOne.isEmpty());
        System.out.println(queueOne.dequeue());
    }
}
