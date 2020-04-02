public class LinkStack<E> implements StackInterface<E> {
    private SNode<E> top = null;

    // returns whether the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // returns the element on top
    public E top() {
        if (top == null) { return null; }
        return top.getData();
    }

    // removes the top element and returns it
    public E pop() {
        if (top == null) { return null; }
        E temp = top.getData();
        top = top.getNext();
        return temp;
    }

    // pushes an element to the top of the stack
    public E push(E item) {
        top = new SNode<E>(item, top);
        return item;
    }

    // returns the size of the stack
    public int size() {
        if (top == null) { return 0; }
        return top.size();
    }
}
