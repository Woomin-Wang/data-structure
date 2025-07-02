package list;

import java.util.Objects;

public class LinkedList<E> implements List<E> {

    private Node<E> first;

    private int size;

    private void linkFirst(E e) {
        final Node<E> oldFirst = first;
        final Node<E> newNode = new Node<>(e, oldFirst);
        first = newNode;
        size++;
    }

    private void linkLast(E e) {
        if (first == null) {
            linkFirst(e);
            return;
        }
        final Node<E> newNode = new Node<>(e, null);
        Node<E> lastNode = getLastNode();
        lastNode.next = newNode;
        size++;
    }

    private void linkBefore(E e, int index) {
        checkPositionIndex(index);

        final Node<E> newNode = new Node<>(e, null);

        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> preNode = getNode(index - 1);
            newNode.next = preNode.next;
            preNode.next = newNode;
        }
        size++;
    }

    private E unlinkFirst() {
        if(first == null) {
            return null;
        }
        Node<E> oldFirst = first;
        E removedValue = oldFirst.item;
        first = oldFirst.next;

        oldFirst.item = null;
        oldFirst.next = null;

        size--;
        return removedValue;
    }

    private E unlinkLast() {
        if(first == null) {
            return null;
        }

        if(size == 1) {
            E removedValue = first.item;
            first = null;
            size--;
            return removedValue;
        }
        Node<E> prev = getNode(size - 2);
        Node<E> last = prev.next;

        E removedValue = last.item;
        prev.next = null;
        last.item = null;
        last.next = null;

        size--;
        return removedValue;
    }

    private E unlink(int index) {
        Node<E> prevNode = getNode(index - 1);
        Node<E> x = prevNode.next;
        E removedValue = x.item;
        prevNode.next = x.next;
        x.item = null;
        x.next = null;

        size--;
        return removedValue;
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private Node<E> getLastNode() {
        Node<E> f = first;
        while (f.next != null) {
            f = f.next;
        }
        return f;
    }

    public Node<E> getNode(int index) {
        Node<E> f = first;
        for (int i = 0; i < index; i++) {
            f = f.next;
        }
        return f;
    }

    @Override
    public void add(E e) {
        linkLast(e);
    }

    @Override
    public void add(int index, E e) {
        linkBefore(e, index);
    }

    @Override
    public E get(int index) {
        Node<E> node = getNode(index);
        return node.item;
    }

    @Override
    public E set(int index, E e) {
        Node<E> node = getNode(index);
        E oldValue = node.item;
        node.item = e;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        checkPositionIndex(index);

        if(index == 0) {
            return unlinkFirst();
        } else if (index == (size - 1)) {
            return unlinkLast();
        } else {
            return unlink(index);
        }
    }

    @Override
    public int indexOf(E o) {
        int index = 0;

        for (Node<E> f = first;  f != null; f = f.next) {
            if(Objects.equals(o, f.item))
                return index;
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if(first == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<E> current = first;

        while(current != null) {
            sb.append(current.item);
            if(current.next != null) {
                sb.append("->");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
