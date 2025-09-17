import java.util.*;

public class day81_suffix_array {
    public static int[] buildSuffixArray(String s) {
        int n=s.length();
        String[] suffixes=new String[n];
        for(int i=0;i<n;i++) suffixes[i]=s.substring(i);
        Arrays.sort(suffixes);
        int[] sa=new int[n];
        for(int i=0;i<n;i++) sa[i]=n-suffixes[i].length();
        return sa;
    }

    public static void main(String[] args) {
        int[] sa=buildSuffixArray("banana");
        System.out.println("Suffix Array: "+Arrays.toString(sa));
    }
}
