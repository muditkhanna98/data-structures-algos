package arrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 0, 5, 6, 8, 7};
        System.out.println(getSecondLargest(arr));
    }

    private static int largest(int[] arr) {
        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }

    public static int getSecondLargest(int[] arr) {
        int largest = arr[0];
        int secondLargest = -1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] != largest) {
                if (secondLargest == -1 || arr[i] > secondLargest) {
                    secondLargest = arr[i];
                }
            }
        }

        return secondLargest;
    }

    public static boolean ifSorted(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            if (arr[i + 1] < arr[i]) return false;
        }

        return true;
    }

    public static void reverse(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroToEnd(int[] arr) {
        int count = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }

        while (count <= arr.length - 1) {
            arr[count] = 0;
            count++;
        }


        System.out.println(Arrays.toString(arr));
    }

}
