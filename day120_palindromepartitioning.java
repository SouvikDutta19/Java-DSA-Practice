// day120_palindromepartitioning.java
import java.util.*;

public class day120_palindromepartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String s, int start, List<String> current, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));
                backtrack(s, end + 1, current, res);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high)
            if (s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }

    public static void main(String[] args) {
        day120_palindromepartitioning obj = new day120_palindromepartitioning();
        System.out.println(obj.partition("aab"));
    }
}
