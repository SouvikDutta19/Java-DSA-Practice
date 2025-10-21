// day114_kmp_lps.java
// KMP pattern search: build LPS (longest prefix suffix) array and find occurrences in text.
import java.util.*;
class Main {
    static int[] buildLPS(String pat){
        int n = pat.length();
        int[] lps = new int[n];
        int len=0;
        for(int i=1;i<n;i++){
            while(len>0 && pat.charAt(i) != pat.charAt(len)) len = lps[len-1];
            if(pat.charAt(i)==pat.charAt(len)) lps[i]=++len;
            else lps[i]=0;
        }
        return lps;
    }
    static List<Integer> kmp(String txt, String pat){
        List<Integer> res = new ArrayList<>();
        if(pat.length()==0) return res;
        int[] lps = buildLPS(pat);
        int i=0,j=0;
        while(i<txt.length()){
            if(txt.charAt(i)==pat.charAt(j)){ i++; j++; }
            if(j==pat.length()){
                res.add(i-j); // match at i-j
                j = lps[j-1];
            } else if(i<txt.length() && txt.charAt(i) != pat.charAt(j)){
                if(j!=0) j = lps[j-1];
                else i++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String pattern = sc.next();
        List<Integer> occ = kmp(text, pattern);
        System.out.println(occ.size());
        for(int pos: occ) System.out.print(pos + " ");
        System.out.println();
        sc.close();
    }
}
