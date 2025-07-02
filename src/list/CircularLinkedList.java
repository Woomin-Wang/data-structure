package list;

import java.util.Objects;

public class CircularLinkedList<E> implements List<E> {

    private Node<E> first;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public void add(E e) {
        add(size, e);
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            if (first == null) { // Empty list
                first = new Node<>(element, null);
                first.next = first; // Points to itself
            } else { // Non-empty list, add at the beginning
                Node<E> last = getNode(size - 1);
                Node<E> newNode = new Node<>(element, first);
                first = newNode;
                last.next = first; // Update last node's next
            }
        } else { // Add in the middle or at the end
            Node<E> prev = getNode(index - 1);
            Node<E> newNode = new Node<>(element, prev.next);
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        return getNode(index).item;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNode(index);
        E oldVal = node.item;
        node.item = element;
        return oldVal;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        E removedValue;
        if (index == 0) {
            removedValue = first.item;
            if (size == 1) {
                first = null;
            } else {
                Node<E> last = getNode(size - 1);
                first = first.next;
                last.next = first;
            }
        } else {
            Node<E> prev = getNode(index - 1);
            Node<E> toRemove = prev.next;
            removedValue = toRemove.item;
            prev.next = toRemove.next;
        }
        size--;
        return removedValue;
    }

    @Override
    public int indexOf(E o) {
        if (first == null) {
            return -1;
        }
        Node<E> current = first;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, current.item)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        if (first == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = first;
        for (int i = 0; i < size; i++) {
            sb.append(current.item);
            if (i < size - 1) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}