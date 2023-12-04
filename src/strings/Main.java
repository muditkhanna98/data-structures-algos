package strings;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str = "abcbd";
        System.out.println(leftMostRepeating(str));
    }

    private static boolean isPalindrome(String str) {
        int begin = 0;
        int end = str.length() - 1;

        while (begin < end) {
            if (str.charAt(begin) != str.charAt(end)) return false;
            begin++;
            end--;
        }

        return true;
    }

    private static boolean subsequence(String str1, String str2) {
        int j = 0;

        for (int i = 0; i < str1.length() && j < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
        }

        return j == str2.length();
    }

    private static boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) return false;

        int[] result = new int[256];

        for (int i = 0; i < first.length(); i++) {
            result[first.charAt(i)]++;
            result[second.charAt(i)]--;
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) return false;
        }

        return true;
    }

    private static int leftMostRepeating(String str) {
        int[] result = new int[256];

        Arrays.fill(result, -1);
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            int fi = result[str.charAt(i)];

            if (fi == -1) {
                result[str.charAt(i)] = i;
            } else {
                answer = Math.min(answer, fi);
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static void reverseWordsInString(char[] str) {
        int start = 0;

        for (int end = 0; end < str.length; end++) {
            if (str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }

        System.out.println(str);
    }

    private static void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }

    }

    private static boolean hasUniqueChars(String str) {
        int[] result = new int[128];

        for (int i = 0; i < str.length(); i++) {
            if (result[str.charAt(i)] != 0) return false;
            result[str.charAt(i)]++;
        }

        return true;
    }
}
