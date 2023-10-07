package recursion;

public class Main {
    public static void main(String[] args) {
        subsequenceOfString("abc", "");
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

    private static int factorial(int digit) {
        if (digit == 0) return 1;
        return digit * factorial(digit - 1);
    }

    private static int fibonacci(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    private static int sumOfNNumbers(int digit) {
        if (digit == 0) return 0;
        return digit + sumOfNNumbers(digit - 1);
    }

    private static int sumOfDigits(int digit) {
        if (digit == 0) return 0;
        return digit % 10 + sumOfDigits(digit / 10);
    }

    //josephus problem (Microsoft question)
    private static int jos(int totalNumberOfPeople, int personToBeKilled) {
        if (totalNumberOfPeople == 1) return 0;
        return (jos(totalNumberOfPeople - 1, personToBeKilled) + personToBeKilled) % totalNumberOfPeople;
    }

    private static int numberOfRopes(int n, int a, int b, int c) {
        if (n == 0) return 0;
        else if (n < 0) return -1;

        int temp1 = numberOfRopes(n - a, a, b, c);
        int temp2 = numberOfRopes(n - b, a, b, c);
        int temp3 = numberOfRopes(n - c, a, b, c);

        int pieces = Math.max(Math.max(temp1, temp2), temp3);
        if (pieces == -1) return -1;
        return pieces + 1;
    }

    private static void subsequenceOfString(String input, String answer) {
        if (input.length() == 0) {
            System.out.println(answer);
            return;
        }
        subsequenceOfString(input.substring(1), answer + input.charAt(0));
        subsequenceOfString(input.substring(1), answer);
    }

}
