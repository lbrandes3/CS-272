public interface StackInterface<E> {
    boolean isEmpty();
    E top();
    E pop();
    E push(E item);
    int size();
}
