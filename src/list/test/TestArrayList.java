package list.test;

import list.List;

import java.util.Arrays;
import java.util.Objects;

public class TestArrayList<E> implements List<E> {

    private Object[] array;

    private int size;

    private int DEFAULT_CAPACITY = 10;

    public TestArrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
    }

    public TestArrayList(int capacity) {
        this.array = new Object[capacity];
    }

    @Override
    public void add(E e) {
        array[size++] = e;
    }

    @Override
    public void add(int index, E element) {
        if(size == 0) {
            array[0] = element;
            size++;
            return;
        }
        shiftRight(index);
        array[index] = element;
        size++;
    }

    private void shiftRight(int index) {
        for (int i = size - 1; i > index; i--) {
            array[i] = array[i -1];
        }
    }

    @Override
    public E remove(int index) {
        E removedValue = get(index);
        for (int i = index; i < size -1; i++) {
            array[i] = array[i + 1];
        }
        array[size--] = null;
        return removedValue;
    }

    @Override
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    public E set(int index, E element) {
        E oldValue = get(index);
        array[index] = element;
        return oldValue;
    }

    @Override
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, array[i])){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}
