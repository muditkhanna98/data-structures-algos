package strings;

public class Main {
    public static void main(String[] args) {
        String str = "abcde";
        System.out.println(longestDistinct("abcdabc"));
    }

    private static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    private static boolean isSubSequence(String str1, String str2) {
        int j = 0;
        for (int i = 0; i < str1.length() && j < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
        }

        return j == str2.length();

    }

    private static boolean isAnagram(String s, String t) {
        int[] count = new int[256];

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    private static int longestDistinct(String str) {
        int n = str.length();
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if (areDistinct(str, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }

    private static boolean areDistinct(String str, int i, int j) {
        boolean[] visited = new boolean[256];

        for (int k = i; k <= j; k++) {
            if (visited[str.charAt(k)]) return false;
            visited[str.charAt(k)] = true;
        }

        return true;
    }
}
