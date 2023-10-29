package sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {10, 20, 1, 1000, 50, 3, 1, 89};
        mergeSort(a);
        System.out.println(Arrays.toString(a));

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

    /*insertion sort*/
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = current;
        }
    }

    public static void mergeSortedArray(int[] a, int low, int mid, int high) {
        int length1 = mid - low + 1;
        int length2 = high - mid;

        int[] left = new int[length1];
        int[] right = new int[length2];

        for (int i = 0; i < length1; i++) {
            left[i] = a[low + i];
        }

        for (int i = 0; i < length2; i++) {
            right[i] = a[mid + i + 1];
        }

        int i = 0, j = 0, k = low;

        while (i < length1 && j < length2) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
                k++;
            } else {
                a[k] = right[j];
                j++;
                k++;
            }
        }

        while (i < length1) {
            a[k] = left[i];
            i++;
            k++;
        }

        while (j < length2) {
            a[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergeSortedArray(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k] = a[i];
                k++;
                i++;
            } else {
                result[k] = b[j];
                k++;
                j++;
            }
        }

        while (i < a.length) {
            result[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            result[k] = b[j];
            j++;
            k++;
        }

        System.out.println(Arrays.toString(result));
    }

    public static void mergeSort(int[] arr) {
        if (arr.length == 1) return;
        int middle = arr.length / 2;

        int[] left = new int[middle];
        for (int i = 0; i < middle; i++) {
            left[i] = arr[i];
        }

        int[] right = new int[arr.length - middle];
        for (int i = middle; i < arr.length; i++) {
            right[i - middle] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);

        //merge two arrays

        mergeArrays(left, right, arr);
    }

    private static void mergeArrays(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }

        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }


}


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] merged = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k] = nums1[i];
                i++;
                k++;
            } else {
                merged[k] = nums2[j];
                j++;
                k++;
            }
        }

        while (i < m) {
            merged[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n) {
            merged[k] = nums2[j];
            j++;
            k++;
        }

        for (int l = 0; l < merged.length; l++) {
            nums1[l] = merged[l];
        }
    }
}
