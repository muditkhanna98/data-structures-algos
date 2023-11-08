package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 0, 4, 5, 3, 0, 6, 7, 8};

        moveZeroesToEnd(arr);
    }

    private static int largestElement(int[] arr) {
        int largest = arr[0];

        for (int j : arr) {
            if (j > largest) {
                largest = j;
            }
        }

        return largest;
    }

    private static int secondLargestElement(int[] arr) {
        int largest = 0;
        int secondLargest = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[largest]) {
                secondLargest = largest;
                largest = i;
            } else if (arr[i] != arr[largest]) {
                if (arr[i] > secondLargest || arr[i] > arr[secondLargest]) {
                    secondLargest = i;
                }
            }
        }

        return secondLargest;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }

        return true;
    }

    private static void reverse(int[] arr) {
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

    private static void moveZeroesToEnd(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }

        System.out.println(Arrays.toString(arr));

    }




}
