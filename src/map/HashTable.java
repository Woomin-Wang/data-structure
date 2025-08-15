package map;

public interface HashTable<E> {

    int hash(E e);

    void insert(E e);

    E search(E e);

    void delete(E e);

    boolean isEmpty();

    boolean isFull();

    void clear();
}
