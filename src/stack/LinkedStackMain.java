package stack;

public class LinkedStackMain {
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();

        stack.push("1");
        stack.push("2");
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push("왕우민");
        System.out.println(stack.peek());
    }
}
