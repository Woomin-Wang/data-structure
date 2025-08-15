package map;

import java.util.LinkedList;

public class ChainHashTable implements HashTable<Integer> {

    public final static int CAPACITY = 10;
    private int size;
    LinkedList[] array = new LinkedList[CAPACITY];

    public ChainHashTable() {
        for (int i = 0; i < CAPACITY; i++) {
            array[i] = new LinkedList<>();
        }
    }

    @Override
    public int hash(Integer integer) {
        int hashValue = (2 * integer) + 1;

        return hashValue % CAPACITY;
    }

    @Override
    public void insert(Integer integer) {
        int hashIndex = hash(integer);

        if (array[hashIndex].contains(integer)) {
            throw new RuntimeException("이미 존재하는 값입니다.");
        }
        array[hashIndex].add(integer);
    }

    @Override
    public Integer search(Integer integer) {
        int hashIndex = hash(integer);

        if (!(array[hashIndex].contains(integer))) {
            throw new RuntimeException("존재 X");
        }

        return (Integer) array[hashIndex].get(array[hashIndex].indexOf(integer));
    }

    @Override
    public void delete(Integer integer) {
        int hashIndex = hash(integer);

        if (!(array[hashIndex].contains(integer))) {
            throw new RuntimeException("존재 X");
        }

        array[hashIndex].remove(integer);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == CAPACITY;
    }

    @Override
    public void clear() {
        array = new LinkedList[CAPACITY];
        size = 0;
    }
}

