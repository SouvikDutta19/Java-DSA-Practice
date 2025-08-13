import java.util.*;

public class day44_suffix_array {
    public static int[] buildSuffixArray(String text) {
        int n = text.length();
        String[] suffixes = new String[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = text.substring(i);
        }
        Arrays.sort(suffixes);
        int[] suffixArr = new int[n];
        for (int i = 0; i < n; i++) {
            suffixArr[i] = n - suffixes[i].length();
        }
        return suffixArr;
    }

    public static void main(String[] args) {
        String text = "banana";
        int[] suffixArray = buildSuffixArray(text);
        System.out.println("Suffix Array:");
        for (int index : suffixArray) {
            System.out.print(index + " ");
        }
    }
}
