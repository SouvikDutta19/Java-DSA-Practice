import java.util.*;

// Palindrome Partitioning using Backtracking
public class day109_palindrome_partitioning {
    static List<List<String>> allPartitions = new ArrayList<>();

    public static void partition(String s) {
        backtrack(s, 0, new ArrayList<>());
    }

    static void backtrack(String s, int start, List<String> current) {
        if (start == s.length()) {
            allPartitions.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                current.add(s.substring(start, i + 1));
                backtrack(s, i + 1, current);
                current.remove(current.size() - 1);
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
        String str = "aab";
        partition(str);
        System.out.println("All possible palindrome partitions:");
        for (List<String> part : allPartitions)
            System.out.println(part);
    }
}
