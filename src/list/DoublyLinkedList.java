package list;

import java.util.Objects;

public class DoublyLinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private Node<E> getNode(int index) {
        Node<E> x = first;

        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public void add(E e) {
        Node<E> last = tail;
        Node<E> newNode = new Node<>(last, e,null);
        tail = newNode;

        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        Node<E> currNode = first;

        if(index == size) {
            add(element);
            return;
        }

        for (int i = 0; i < index - 1; i++) {
            currNode = currNode.next;
        }
        Node<E> newNode = new Node<>(null, element, null);

        newNode.prev = currNode;
        newNode.next = currNode.next;
        currNode.next = newNode;
        currNode.next.prev = newNode;

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
        Node<E> removedNode = getNode(index);
        Node<E> prevNode = removedNode.prev;

        if(removedNode.next == null) {
            prevNode.next = null;
            tail = prevNode;
            size--;
            return removedNode.item;
        }
        prevNode.next = removedNode.next;
        removedNode.next.prev = prevNode;
        size--;
        return removedNode.item;
    }

    @Override
    public int indexOf(E o) {
        int index = 0;
        Node<E> x = first;
        while (x != null) {
            if (Objects.equals(o, x.item)) {
                return index;
            }
            index++;
            x = x.next;
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
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
