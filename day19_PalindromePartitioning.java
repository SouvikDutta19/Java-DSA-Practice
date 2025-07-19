import java.util.*;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> tempList, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String part = s.substring(start, end);
            if (isPalindrome(part)) {
                tempList.add(part);
                backtrack(s, end, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> result = partition("aab");
        for (List<String> list : result)
            System.out.println(list);
    }
}
