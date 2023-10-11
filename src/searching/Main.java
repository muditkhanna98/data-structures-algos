package searching;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 8, 9, 15};
        System.out.println(ternarySearch(arr, 9));
    }

    private static int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length - 1);
    }

    //recursive
    private static int binarySearch(int[] arr, int target, int low, int high) {
        if (high < low) return -1;
        int middle = (low + high) / 2;
        if (arr[middle] == target) return middle;

        if (target < arr[middle]) return binarySearch(arr, target, low, middle - 1);
        else return binarySearch(arr, target, middle + 1, high);
    }

    private static int binarySearchIterative(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int middle = (low + high) / 2;
            if (arr[middle] == target) return middle;
            else if (target < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    private static int ternarySearch(int[] arr, int target) {
        return ternarySearch(arr, target, 0, arr.length - 1);
    }

    //ternary search
    private static int ternarySearch(int[] arr, int target, int low, int high) {
        if (low > high) return -1;
        int partitionSize = (high - low) / 3;
        int mid1 = low + partitionSize;
        int mid2 = high - partitionSize;

        if (arr[mid1] == target) return mid1;
        if (arr[mid2] == target) return mid2;

        if (target < arr[mid1]) return ternarySearch(arr, target, low, mid1 - 1);

        if (target > arr[mid2]) return ternarySearch(arr, target, mid2 + 1, high);
        return ternarySearch(arr, target, mid1 + 1, mid2 - 1);
    }

}
