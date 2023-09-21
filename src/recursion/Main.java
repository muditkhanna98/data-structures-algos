package recursion;

public class Main {
    public static void main(String[] args) {
        print1ToN(5);
    }

    private static void printNTo1(int digit) {
        if (digit == 0) return;
        System.out.println(digit);
        printNTo1(digit - 1);
    }

    private static void print1ToN(int digit) {
        if (digit == 0) return;
        print1ToN(digit - 1);
        System.out.println(digit);
    }
}
