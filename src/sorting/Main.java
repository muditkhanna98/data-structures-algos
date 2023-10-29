package sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 9, 6, 9, 15, 6, 7};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*bubble sort*/
    public static void bubbleSort(int[] arr) {
        boolean isSorted = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                isSorted = true;
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) return;
        }
    }

    /*selection sort*/
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

    }

}
