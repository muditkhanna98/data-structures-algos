package mathematics;

public class Main {
    public static void main(String[] args) {
        System.out.println(efficientTrailingZeroFactorial(100));
    }

    private static int getNumberOfDigits(int digit) {
        int count = 0;
        while (digit > 0) {
            digit = digit / 10;
            count++;
        }

        return count;
    }

    private static boolean isPalindrome(int digit) {
        int temp = digit;
        int result = 0;
        while (digit > 0) {
            int lastDigit = digit % 10;
            result = result * 10 + lastDigit;
            digit = digit / 10;
        }

        return (result == temp);
    }

    private static int getNaiveFactorial(int digit) {
        int result = 1;

        for (int i = 1; i <= digit; i++) {
            result = result * i;
        }

        return result;
    }

    private static int getRecursiveFactorial(int digit) {
        if (digit == 0) {
            return 1;
        }
        return digit * getRecursiveFactorial(digit - 1);
    }

    private static int getTrailingZeroFactorial(int digit) {
        int result = 1;
        int countOfZeroes = 0;

        for (int i = 2; i <= digit; i++) {
            result = result * i;
        }

        while (result > 0) {
            int lastDigit = result % 10;
            result = result / 10;
            if (lastDigit == 0) {
                countOfZeroes++;
            } else break;
        }

        return countOfZeroes;

    }

    private static int efficientTrailingZeroFactorial(int digit) {
        int result = 0;

        for (int i = 5; i <= digit; i = i * 5) {
            result = result + digit / i;
        }

        return result;
    }
}
