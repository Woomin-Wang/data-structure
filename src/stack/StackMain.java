package stack;

public class StackMain {
    public static void main(String[] args) {

        ArrayStack<String> stack = new ArrayStack<String>();
        stack.push("왕우민");
        stack.push("강은현");
        stack.push("오준택");
        System.out.println(stack);
        System.out.println();

        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println(stack);
        System.out.println();

        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.pop() = " + stack.pop());
//        System.out.println("stack.peek() = " + stack.peek()); // 예외 발생
        System.out.println();

//        stack.pop(); // 예외 발생

        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        stack.push("10");
        System.out.println(stack);
//        stack.push("11"); // 예외 발생


    }
}
