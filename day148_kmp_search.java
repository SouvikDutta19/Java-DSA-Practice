// Day148 KMP pattern search (prefix function / lps)
import java.util.*;
public class Day148KmpSearch {
    public static int[] buildLPS(String pat){
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0;
        for(int i=1;i<m;){
            if(pat.charAt(i) == pat.charAt(len)){
                lps[i++] = ++len;
            } else {
                if(len != 0) len = lps[len-1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }

    public static List<Integer> kmpSearch(String txt, String pat){
        List<Integer> res = new ArrayList<>();
        if(pat.length() == 0) return res;
        int[] lps = buildLPS(pat);
        int i=0,j=0;
        while(i < txt.length()){
            if(txt.charAt(i) == pat.charAt(j)){
                i++; j++;
                if(j == pat.length()){
                    res.add(i-j);
                    j = lps[j-1];
                }
            } else {
                if(j != 0) j = lps[j-1];
                else i++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        String txt = "abxabcabcaby";
        String pat = "abcaby";
        System.out.println("Occurrences at indices: " + kmpSearch(txt, pat));
    }
}
