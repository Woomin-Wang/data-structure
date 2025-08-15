package stack;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {

    public final static int DEFAULT_CAPACITY = 10;
    private int size;
    Object array[];

    public ArrayStack() {
        array = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(E e) {
        if (isFull()) throw new ArrayIndexOutOfBoundsException("스택이 꽉 찼습니다.");

        array[size++] = e;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("스택이 비어 있습니다.");

        Object top = array[size - 1];
        array[size - 1] = null;
        size--;
        return (E) top;
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("스택이 비어 있습니다.");

        Object top = array[size - 1];
        return (E) top;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return array.length <= size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

}
