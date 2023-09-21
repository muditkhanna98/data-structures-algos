package mathematics;

public class Main {
    public static void main(String[] args) {
        System.out.println(gcdOptimized(12, 15));
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

    private static int gcd(int a, int b) {
        int result = Math.min(a, b); // Because the largest divisor will be the min of both the numbers

        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }

            result--;
        }

        return result;
    }

   /* Euclidean Algorithm
     Let 'b' be smaller than 'a'
    then gcd(a,b) = gcd(a-b,b) */

    private static int gcdOptimized(int a, int b) {
        if (b == 0) return a;
        else return gcdOptimized(b, a % b);
    }
}
