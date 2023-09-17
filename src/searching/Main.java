package searching;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 10, 10, 10, 15, 18, 18};
        System.out.println(findLastOccurrence(arr, 10));
    }

    public static int binarySearch(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == item) return mid;
            else if (arr[mid] > item) {
                high = mid - 1;
            } else low = mid + 1;
        }

        return -1;
    }

    public static int findFirstOccurrence(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < item) {
                low = mid + 1;
            } else if (arr[mid] > item) {
                high = mid - 1;
            } else {
                if (mid == 0 || arr[mid - 1] != arr[mid]) return mid;
                else high = mid - 1;
            }
        }

        return -1;
    }

    public static int findLastOccurrence(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < item) {
                low = mid + 1;
            } else if (arr[mid] > item) {
                high = mid - 1;
            } else {
                if (mid != arr.length - 1 || arr[mid] != arr[mid + 1]) return mid;
                else low = mid + 1;
            }
        }

        return -1;
    }
}
