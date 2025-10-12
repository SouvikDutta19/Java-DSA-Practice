import java.util.*;

// Naive suffix array construction (easy to understand, O(n^2 log n) due to substring comparisons)
public class day106_suffixarray {
    static class Suffix implements Comparable<Suffix> {
        final String suff;
        final int index;
        Suffix(String s, int i) { suff = s; index = i; }
        public int compareTo(Suffix o) { return suff.compareTo(o.suff); }
    }

    public static int[] buildSuffixArray(String txt) {
        int n = txt.length();
        Suffix[] suffixes = new Suffix[n];
        for (int i = 0; i < n; i++) suffixes[i] = new Suffix(txt.substring(i), i);
        Arrays.sort(suffixes);
        int[] sa = new int[n];
        for (int i = 0; i < n; i++) sa[i] = suffixes[i].index;
        return sa;
    }

    // Longest common prefix between two suffixes given sa and original string
    public static int lcp(String s, int i, int j) {
        int n = s.length();
        int l = 0;
        while (i < n && j < n && s.charAt(i) == s.charAt(j)) { l++; i++; j++; }
        return l;
    }

    public static void main(String[] args) {
        String text = "banana";
        int[] sa = buildSuffixArray(text);
        System.out.println("Suffix Array:");
        for (int idx : sa) System.out.println(idx + ": " + text.substring(idx));
        System.out.println("LCP array:");
        for (int i = 1; i < sa.length; i++) System.out.println("LCP(" + sa[i-1] + "," + sa[i] + ") = " + lcp(text, sa[i-1], sa[i]));
    }
}
