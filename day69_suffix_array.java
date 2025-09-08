import java.util.*;

public class day69_suffix_array {
    static int[] buildSuffixArray(String s) {
        int n = s.length();
        String[] suffixes = new String[n];
        for (int i = 0; i < n; i++) suffixes[i] = s.substring(i);
        Arrays.sort(suffixes);
        int[] sa = new int[n];
        for (int i = 0; i < n; i++) sa[i] = n - suffixes[i].length();
        return sa;
    }

    public static void main(String[] args) {
        String s = "banana";
        int[] sa = buildSuffixArray(s);
        System.out.println(Arrays.toString(sa));
    }
}
