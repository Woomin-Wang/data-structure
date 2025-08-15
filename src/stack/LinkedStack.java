package stack;

public class LinkedStack<E> implements Stack<E> {

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    public Node<E> top;
    private int size;

    @Override
    public void push(E e) {
        Node<E> newNode = new Node<>(e, null);

        if (top == null) { // 스택이 비어있을 경우
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        E popElement = top.item;
        top = top.next;
        size--;
        return popElement;
    }

    @Override
    public E peek() {
        return top.item;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("]");

        Node<E> current = top;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("[");
        sb.reverse();
        return sb.toString();
    }
}
