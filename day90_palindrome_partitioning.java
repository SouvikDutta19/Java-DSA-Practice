import java.util.*;

public class day90_palindrome_partitioning {
    static List<List<String>> res;

    public static List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    private static void backtrack(String s, int start, List<String> path) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String substr = s.substring(start, end);
            if (isPalindrome(substr)) {
                path.add(substr);
                backtrack(s, end, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Palindrome Partitioning: " + partition("aab"));
    }
}
