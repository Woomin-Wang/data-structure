package recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(fatorial(5));
    }

    public static int fatorial(int num) {
        if(num == 0) {
            return 1;
        }

        return fatorial(num - 1) * num;
    }
}
