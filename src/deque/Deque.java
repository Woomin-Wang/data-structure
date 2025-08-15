package deque;

public interface Deque<E>{

    void addFront(E e);

    void addRear(E e);

    E deleteFront();

    E deleteRear();

    boolean isEmpty();

    boolean isFull();

    int size();

    void clear();
}




