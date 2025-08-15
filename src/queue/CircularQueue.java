package queue;

public class CircularQueue<E> implements Queue<E> {

    public final static int DEFAULT_CAPACITY = 10;
    private int tail;
    private int front;
    private int size;
    private Object[] array;

    public CircularQueue() {
        array = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("큐가 가득찼습니다.");
        }
        array[tail] = e;

        if ((tail + 1) % array.length == front) {
            tail = 0;
        } else {
            tail++;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("큐가 비어있습니다.");
        }
        Object value = array[front];
        array[front] = null;

        if ((front + 1) % array.length == tail) {
            front = 0;
        } else {
            front++;
        }

        size--;
        return (E) value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("큐가 비어있습니다.");
        }
        return (E) array[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return array.length == size;
    }
}
