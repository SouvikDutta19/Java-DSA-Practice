import java.util.*;

public class day166_palindrome_partitioning {

    static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }

    static void backtrack(String s, int start,
                          List<String> path, List<List<String>> res) {

        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                path.add(s.substring(start, i + 1));
                backtrack(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), res);

        for (List<String> list : res)
            System.out.println(list);
    }
}