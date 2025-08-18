import java.util.*;

public class day49_suffix_array {
    public static int[] buildSuffixArray(String s) {
        int n = s.length();
        Integer[] order = new Integer[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            order[i] = i;
            rank[i] = s.charAt(i);
        }

        for (int len = 1; len < n; len *= 2) {
            final int length = len;
            Arrays.sort(order, (a, b) -> {
                if (rank[a] != rank[b]) return rank[a] - rank[b];
                int ra = a + length < n ? rank[a + length] : -1;
                int rb = b + length < n ? rank[b + length] : -1;
                return ra - rb;
            });

            int[] newRank = new int[n];
            newRank[order[0]] = 0;
            for (int i = 1; i < n; i++) {
                newRank[order[i]] = newRank[order[i - 1]];
                if (rank[order[i]] != rank[order[i - 1]] ||
                        ((order[i] + len < n ? rank[order[i] + len] : -1) !=
                                (order[i - 1] + len < n ? rank[order[i - 1] + len] : -1))) {
                    newRank[order[i]]++;
                }
            }
            rank = newRank;
        }

        return Arrays.stream(order).mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        String s = "banana";
        int[] suffixArr = buildSuffixArray(s);
        System.out.println("Suffix Array: " + Arrays.toString(suffixArr));
    }
}
