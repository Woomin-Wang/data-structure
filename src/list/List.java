package list;

public interface List<E> {

    int size();

    void add(E e);

    void add(int index, E element);

    E get(int index);

    E set(int index, E element);

    E remove(int index);

    int indexOf(E o);
}

