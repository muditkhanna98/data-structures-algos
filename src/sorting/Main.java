package sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {3, 2, 10, 3, 9};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    //O(n2)
    private static void bubbleSort(int[] array) {
        boolean isSorted;

        for (int i = 0; i < array.length; i++) {
            isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) return;
        }
    }

    //O(n2)
    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minimumIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minimumIndex];
            array[minimumIndex] = temp;
        }
    }

}
