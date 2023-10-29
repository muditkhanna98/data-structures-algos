package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);

        System.out.println(Arrays.toString(result));
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

    private static int trappingRainWater(int[] arr) {
        int result = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            int lMax = arr[i];
            for (int j = 0; j < i; j++) {
                lMax = Math.max(lMax, arr[j]);
            }

            int rMax = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                rMax = Math.max(rMax, arr[j]);
            }

            result = result + Math.min(lMax, rMax) - arr[i];
        }

        return result;
    }

    private static int trappingRainWaterEfficient(int[] arr) {
        int result = 0;
        int[] lMax = new int[arr.length];
        int[] rMax = new int[arr.length];

        lMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lMax[i] = Math.max(arr[i], lMax[i - 1]);
        }

        rMax[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(arr[i], rMax[i + 1]);
        }

        for (int i = 1; i < arr.length - 1; i++) {
            result = result + Math.min(lMax[i], rMax[i]) - arr[i];
        }

        return result;
    }

    private static int maximumConsecutiveOnes(int[] arr) {
        int current = 0;
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                current = 0;
            } else {
                current++;
                result = Math.max(current, result);
            }
        }

        return result;
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexedNum = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];

            if (indexedNum.containsKey(difference)) {
                return new int[]{indexedNum.get(difference), i};
            }

            indexedNum.put(nums[i], i);
        }

        return new int[]{};
    }
}
