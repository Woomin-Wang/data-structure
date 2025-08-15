package queue;

public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E peek();

    boolean isEmpty();

    boolean isFull();

    int size();
}






