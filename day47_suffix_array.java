import java.util.*;

public class day47_suffix_array {
    static class Suffix implements Comparable<Suffix> {
        int index;
        String suffix;

        Suffix(int index, String suffix) {
            this.index = index;
            this.suffix = suffix;
        }

        @Override
        public int compareTo(Suffix s) {
            return this.suffix.compareTo(s.suffix);
        }
    }

    public static int[] buildSuffixArray(String text) {
        int n = text.length();
        Suffix[] suffixes = new Suffix[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = new Suffix(i, text.substring(i));
        }
        Arrays.sort(suffixes);
        int[] suffixArr = new int[n];
        for (int i = 0; i < n; i++) {
            suffixArr[i] = suffixes[i].index;
        }
        return suffixArr;
    }

    public static void main(String[] args) {
        String text = "banana";
        int[] suffixArr = buildSuffixArray(text);
        System.out.println("Suffix Array:");
        for (int i : suffixArr) System.out.print(i + " ");
    }
}
