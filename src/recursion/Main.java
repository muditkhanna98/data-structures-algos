package recursion;

public class Main {
    public static void main(String[] args) {
        System.out.println(jos(7, 3));
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

    private static int maxPieces(int length, int a, int b, int c) {
        if (length == 0) return 0;
        if (length < 0) return -1;

        int result = Math.max(Math.max(maxPieces(length - a, a, b, c), maxPieces(length - b, a, b, c)), maxPieces(length - c, a, b, c));
        if (result == -1) return -1;
        return result + 1;
    }

    //josephus problem (Microsoft question)
    private static int jos(int totalNumberOfPeople, int personToBeKilled) {
        if (totalNumberOfPeople == 1) return 0;
        return (jos(totalNumberOfPeople - 1, personToBeKilled) + personToBeKilled) % totalNumberOfPeople;
    }

}
