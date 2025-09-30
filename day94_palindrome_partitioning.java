import java.util.*;

public class day94_palindrome_partitioning {
    static List<List<String>> result = new ArrayList<>();

    static void backtrack(String s, int start, List<String> path) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s, int l, int r) {
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    public static void main(String[] args) {
        backtrack("aab", 0, new ArrayList<>());
        System.out.println(result);
    }
}
