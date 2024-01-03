package searching;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 1, 1, 1, 1};
        System.out.println(squareRoot(10));
    }

    private static int binarySearchIterative(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == item) return mid;
            if (item < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private static int binarySearchRec(int[] arr, int low, int high, int item) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (item == arr[mid]) return mid;
        if (item > arr[mid]) {
            return binarySearchRec(arr, mid + 1, high, item);
        } else {
            return binarySearchRec(arr, low, mid - 1, item);
        }

    }

    private static int indexOfFirstOccurrence(int[] arr, int low, int high, int item) {
        int mid = (low + high) / 2;

        if (item == arr[mid]) {
            if (mid == 0 || arr[mid - 1] != arr[mid]) {
                return mid;
            }
            return indexOfFirstOccurrence(arr, low, mid - 1, item);
        }

        if (item > arr[mid]) return indexOfFirstOccurrence(arr, mid + 1, high, item);
        else if (item < arr[mid]) return indexOfFirstOccurrence(arr, low, mid - 1, item);

        return -1;
    }

    private static int indexOfFirstOccurrenceIterative(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (item > arr[mid]) {
                low = mid + 1;
            } else if (item < arr[mid]) {
                high = mid - 1;
            } else {
                if (mid == 0 || arr[mid] != arr[mid - 1]) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int indexOfLastOccurrence(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (item < arr[mid]) {
                high = mid - 1;
            } else if (item > arr[mid]) {
                low = mid + 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != arr[mid]) {
                    return mid;
                }
                return low = mid + 1;
            }
        }
        return -1;
    }

    private static int countOnes(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 0) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid] != arr[mid - 1]) {
                    return arr.length - mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    //binary search to find square root of a number
    private static int squareRoot(int num) {
        int low = 1;
        int high = num;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int midSquare = mid * mid;
            if (midSquare == num) {
                return mid;
            } else if (midSquare > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    //one half of the array will always be sorted
    //compare the middle element with the corner elements to know which half of the array is sorted
    //compare element to be searched with the middle and the corner case and then search in that half using binary search
    private static int searchInSortedRotatedArray(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == item) {
                return mid;
            }
            if (arr[low] <= arr[mid]) {
                if (item >= arr[low] && item <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (item >= arr[mid] && item <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }


}
