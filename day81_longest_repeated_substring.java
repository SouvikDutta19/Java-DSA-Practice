import java.util.*;

public class day81_longest_repeated_substring {
    public static String lrs(String s) {
        int n=s.length();
        String[] suffixes=new String[n];
        for(int i=0;i<n;i++) suffixes[i]=s.substring(i);
        Arrays.sort(suffixes);
        String lrs="";
        for(int i=0;i<n-1;i++) {
            String x=lcp(suffixes[i],suffixes[i+1]);
            if(x.length()>lrs.length()) lrs=x;
        }
        return lrs;
    }

    static String lcp(String a,String b) {
        int n=Math.min(a.length(),b.length());
        for(int i=0;i<n;i++) if(a.charAt(i)!=b.charAt(i)) return a.substring(0,i);
        return a.substring(0,n);
    }

    public static void main(String[] args) {
        System.out.println("Longest Repeated Substring: "+lrs("banana"));
    }
}
