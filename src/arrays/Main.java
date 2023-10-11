package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 8, 12};
        System.out.println(maxProfitEfficient(arr));
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

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) return false;
        }

        return true;
    }

    private static void reverse(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void leftRotateBy1(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        arr[arr.length - 1] = temp;

        System.out.println(Arrays.toString(arr));
    }

    private static void leftRotateByD(int[] arr, int d) {
        // do above function inside a loop
    }

    private static void printLeaders(int[] arr) {
        //all the elements that are greater than all the elements on its right are leaders
        //right most element is always a leader
        int current = arr[arr.length - 1];
        System.out.println(current);

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > current) {
                current = arr[i];
                System.out.println(arr[i]);
            }
        }

    }

    private static void frequencies(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> value : map.entrySet()) {
            System.out.println(value.getKey() + " " + value.getValue());
        }
    }

    //stock buy and sell problem
    private static int maxProfit(int[] arr) {
        int maxProfit = 0;
        int minSoFar = arr[0];

        for (int i = 0; i < arr.length; i++) {
            minSoFar = Math.min(minSoFar, arr[i]);
            int profit = arr[i] - minSoFar;
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }

    //you buy the stock when it is at bottom and sell it on the top
    private static int maxProfitEfficient(int[] arr) {
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += (arr[i] - arr[i - 1]);
            }
        }

        return profit;
    }

    private static int maximumDifference(int[] arr) {
        int result = arr[1] - arr[0];
        int minimum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result = Math.max(result, arr[i] - minimum);
            minimum = Math.min(minimum, arr[i]);
        }

        return result;
    }
}
