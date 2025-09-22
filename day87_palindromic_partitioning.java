import java.util.*;

public class day87_palindromic_partitioning {
    static List<List<String>> result = new ArrayList<>();

    static boolean isPalindrome(String s, int l, int r) {
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    static void dfs(String s, int start, List<String> path) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                dfs(s, end + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        dfs(s, 0, new ArrayList<>());
        System.out.println(result);
    }
}
