import java.util.*;

public class day72_suffix_array {
    static int[] buildSuffixArray(String s){
        int n=s.length();
        Integer[] order=new Integer[n];
        for(int i=0;i<n;i++) order[i]=i;
        Arrays.sort(order,(a,b)->s.substring(a).compareTo(s.substring(b)));
        int[] sa=new int[n];
        for(int i=0;i<n;i++) sa[i]=order[i];
        return sa;
    }

    public static void main(String[] args){
        String s="banana";
        int[] sa=buildSuffixArray(s);
        System.out.println(Arrays.toString(sa));
    }
}
