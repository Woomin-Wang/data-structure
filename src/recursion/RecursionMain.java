package recursion;

public class RecursionMain {
    public static void main(String[] args) {
        myFunc(1);
    }

    static void myFunc(int number) {
        if(number > 10) return;

        System.out.println(number);
        myFunc(number + 1);
    }
}
