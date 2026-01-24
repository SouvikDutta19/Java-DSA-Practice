import java.util.*;

public class day182_palindrome_partitioning {

    static List<List<String>> res = new ArrayList<>();

    static void backtrack(String s, int idx, List<String> curr) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                curr.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s, int l, int r) {
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        return true;
    }

    public static void main(String[] args) {
        backtrack("aab", 0, new ArrayList<>());
        System.out.println(res);
    }
}