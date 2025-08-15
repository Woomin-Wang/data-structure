package list;

import java.util.Objects;

public class CircularLinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
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
        final Node<E> l = tail;
        final Node<E> newNode = new Node<>(l, e, first); // 원형 만들어줌
        tail = newNode;
        if (l == null) {
            first = newNode;
            newNode.next = first;
            newNode.prev = first;
        } else {
            l.next = newNode; // 이전 tail의 next가 newNode
            first.prev = newNode;  // 원형 구조 만들어줌
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == size) {
            add(element);
        } else {
            Node<E> succ = getNode(index);
            Node<E> pred = succ.prev;
            Node<E> newNode = new Node<>(pred, element, succ);  // 사이에 생성
            succ.prev = newNode;

            if (pred == tail) { // 맨앞에 삽입하는 경우임
                first = newNode;
                tail.next = first;
            } else {
                pred.next = newNode; // 일반적인 경우
            }
            size++;
        }
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

        Node<E> removedNode = getNode(index);
        E removedValue = removedNode.item;
        Node<E> pred = removedNode.prev;
        Node<E> succ = removedNode.next;

        if (size == 1) {  // 리스트 요소 1개일 때
            first = null;
            tail = null;
        } else {
            pred.next = succ;
            succ.prev = pred;
            if (removedNode == first) {
                first = succ;
            }
            if (removedNode == tail) {
                tail = pred;
            }
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
