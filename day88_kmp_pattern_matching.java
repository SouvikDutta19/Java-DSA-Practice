public class day88_kmp_pattern_matching {
    static void kmpSearch(String text, String pat) {
        int m=pat.length(), n=text.length();
        int[] lps=new int[m];
        int j=0;
        computeLPS(pat,lps);
        int i=0;
        while(i<n){
            if(pat.charAt(j)==text.charAt(i)){i++;j++;}
            if(j==m){
                System.out.println("Pattern found at index "+(i-j));
                j=lps[j-1];
            } else if(i<n && pat.charAt(j)!=text.charAt(i)){
                if(j!=0) j=lps[j-1];
                else i++;
            }
        }
    }
    static void computeLPS(String pat,int[] lps){
        int len=0,i=1;
        lps[0]=0;
        while(i<pat.length()){
            if(pat.charAt(i)==pat.charAt(len)){len++;lps[i]=len;i++;}
            else{if(len!=0) len=lps[len-1]; else {lps[i]=0;i++;}}
        }
    }

    public static void main(String[] args){
        kmpSearch("abxabcabcaby","abcaby");
    }
}
