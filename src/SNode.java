public class SNode<E> {
    private SNode next;
    private E data;

    public SNode(E data, SNode next) {
        this.data = data;
        this.next = next;
    }

    public SNode getNext() {
        return next;
    }

    public void setNext(SNode next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public int size() {
        if (next == null) {
            return 1;
        }
        return next.size() + 1;
    }
}
