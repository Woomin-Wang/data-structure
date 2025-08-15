package map;

public class ArrayHashTable implements HashTable<Integer> {

    public final static int CAPACITY = 10;
    private int size;
    Object[] array = new Object[CAPACITY];

    @Override
    public int hash(Integer integer) {
        int hashValue = (2 * integer) + 1;

        return hashValue % CAPACITY;
    }

    @Override
    public void insert(Integer integer) {
        int hashIndex = hash(integer);

        if (array[hashIndex] != null) { // 해시 충돌
            throw new ArrayIndexOutOfBoundsException("이미 값이 존재합니다.");
        }

        size++;
        array[hashIndex] = integer;
    }

    @Override
    public Integer search(Integer integer) {
        int hashIndex = hash(integer);

        if (array[hashIndex] == null) {
            throw new ArrayIndexOutOfBoundsException("접근하려는 인덱스에 값이 존재하지 않습니다.");
        }

        return (Integer) array[hashIndex];
    }

    @Override
    public void delete(Integer integer) {
        int hashIndex = hash(integer);

        size--;
        array[hashIndex] = null;
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
        array = new Object[CAPACITY];
        size = 0;
    }
}
