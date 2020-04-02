import java.util.ArrayList;

public class ArraylistStack<E> implements StackInterface<E> {
    private ArrayList<E> stack = new ArrayList<E>();

    // returns whether the stack is empty
    public boolean isEmpty() {
        return stack.size() == 0;
    }

    // returns the element on top
    public E top() {
        if (stack.size() == 0) { return null; }
        return stack.get(stack.size() - 1);
    }

    // removes the top element and returns it
    public E pop() {
        if (stack.size() == 0) { return null; }
        E temp = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return temp;
    }

    // pushes an element to the top of the stack
    public E push(E item) {
        stack.add(item);
        return item;
    }

    // returns the size of the stack
    public int size() {
        return stack.size();
    }
}
