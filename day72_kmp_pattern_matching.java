import java.util.*;

public class day72_kmp_pattern_matching {
    static int[] lps(String pat){
        int n=pat.length(),len=0,i=1;
        int[] lps=new int[n];
        while(i<n){
            if(pat.charAt(i)==pat.charAt(len)) lps[i++]=++len;
            else if(len!=0) len=lps[len-1];
            else lps[i++]=0;
        }
        return lps;
    }

    static void search(String txt,String pat){
        int[] l=lps(pat);
        int i=0,j=0;
        while(i<txt.length()){
            if(txt.charAt(i)==pat.charAt(j)){i++;j++;}
            if(j==pat.length()){ System.out.println("Found at "+(i-j)); j=l[j-1]; }
            else if(i<txt.length() && txt.charAt(i)!=pat.charAt(j)){
                if(j!=0) j=l[j-1]; else i++;
            }
        }
    }

    public static void main(String[] args){
        search("ababcababaad","ababa");
    }
}
