package deque;

public class ArrayDeque<E> implements Deque<E> {

    public final static int DEFAULT_CAPACITY = 10;
    private int front;
    private int rear;
    private int size;
    private Object[] array;

    public ArrayDeque() {
        array = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void addFront(E e) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("큐가 가득찼습니다.");
        }
        front = (front - 1 + array.length) % array.length;
        array[front] = e;
        size++;
    }

    @Override
    public void addRear(E e) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("큐가 가득찼습니다.");
        }
        array[rear] = e;
        rear = (rear + 1) % array.length;
        size++;
    }

    @Override
    public E deleteFront() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("큐가 비어있습니다.");
        }

        Object deletedValue = array[front];
        array[front] = null;

        front = (front + 1) % array.length;
        size--;
        return (E) deletedValue;
    }

    @Override
    public E deleteRear() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("큐가 비어있습니다.");
        }
        rear = (rear - 1 + array.length) % array.length;

        Object deletedValue = array[rear];
        array[rear] = null;

        size--;
        return (E) deletedValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }
}
