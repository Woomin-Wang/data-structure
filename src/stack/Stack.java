package stack;

public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    boolean isEmpty();

    boolean isFull();

    int size();

    void clear();
}
