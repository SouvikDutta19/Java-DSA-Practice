import java.util.*;

public class day70_suffix_array {
    static int[] buildSuffixArray(String s) {
        int n = s.length();
        String[] suffixes = new String[n];
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = s.substring(i);
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> suffixes[a].compareTo(suffixes[b]));
        return Arrays.stream(idx).mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        String s="banana";
        int[] sa=buildSuffixArray(s);
        System.out.println(Arrays.toString(sa));
    }
}
