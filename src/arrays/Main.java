package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1};

        System.out.println(findMaxConsecutiveOnes(arr));
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

    private static int maxSumSubArray(int[] arr, int k) {
        int wSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            wSum += arr[i];
        }

        for (int i = k; i < arr.length; i++) {
            wSum = wSum - arr[i - k] + arr[i];
            maxSum = Math.max(wSum, maxSum);
        }

        return maxSum;
    }

    private static boolean subArrayWithGivenSum(int[] arr, int sum) {
        int start = 0;
        int cSum = 0;

        for (int end = 0; end < arr.length; end++) {
            cSum += arr[end];

            while (sum < cSum) {
                cSum -= arr[start];
                start++;
            }

            if (cSum == sum) return true;
        }

        return false;
    }

    private static void leftRotateArrayByOne(int[] arr) {
        int firstElement = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = firstElement;

        System.out.println(Arrays.toString(arr));
    }

    private static void leftRotateArrayByD(int[] arr, int d) {
        //first reverse d elements
        //second reverse the n-d elements
        //third reverse the whole array
        if (arr.length == 1) return;
        d = d % arr.length;

        reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }

    private static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    private static void printLeaders(int[] arr) {
        int currentLeader = arr[arr.length - 1];
        System.out.println(currentLeader);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > currentLeader) {
                currentLeader = arr[i];
                System.out.println(currentLeader);
            }
        }
    }

    private static int maximumDifference(int[] arr) {
        int min = arr[0];
        int maxDifference = 0;

        for (int i = 0; i < arr.length; i++) {
            maxDifference = Math.max(maxDifference, arr[i] - min);
            min = Math.min(min, arr[i]);
        }

        return (maxDifference > 0) ? maxDifference : -1;
    }

    private static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> differencesMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int difference = target - arr[i];

            if (differencesMap.containsKey(difference)) {
                return new int[]{differencesMap.get(difference), i};
            }
            differencesMap.put(arr[i], i);
        }

        return new int[]{};
    }

    private static int stockBuyAndSellProblem(int[] arr) {
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += (arr[i] - arr[i - 1]);
            }
        }

        return profit;
    }

    private static int trappingRainWater(int[] arr) {
        int result = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            int lMax = arr[i];
            int rMax = arr[i];

            for (int j = 0; j < i; j++) {
                lMax = Math.max(lMax, arr[j]);
            }

            for (int j = i + 1; j < arr.length; j++) {
                rMax = Math.max(rMax, arr[j]);
            }

            result = result + (Math.min(lMax, rMax) - arr[i]);
        }

        return result;
    }

    private static int trappingRainWaterEfficientSol(int[] arr) {
         /*idea is to precompute left max and right max for
        every element in the array and then use it later*/

        int result = 0;
        int[] lMax = new int[arr.length];
        int[] rMax = new int[arr.length];

        lMax[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            lMax[i] = Math.max(lMax[i - 1], arr[i]);
        }

        rMax[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(arr[i], rMax[i + 1]);
        }

        for (int i = 1; i < arr.length - 1; i++) {
            result = result + (Math.min(lMax[i], rMax[i]) - arr[i]);
        }

        return result;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int currentMax = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentMax++;
                result = Math.max(currentMax, result);
            } else {
                currentMax = 0;
            }
        }

        return result;
    }


}
