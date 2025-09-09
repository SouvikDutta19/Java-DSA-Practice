public class day70_rabin_karp {
    static final int d=256, q=101;

    static void search(String pat, String txt) {
        int m=pat.length(), n=txt.length();
        int p=0,t=0,h=1;
        for(int i=0;i<m-1;i++) h=(h*d)%q;
        for(int i=0;i<m;i++){ p=(d*p+pat.charAt(i))%q; t=(d*t+txt.charAt(i))%q; }

        for(int i=0;i<=n-m;i++){
            if(p==t && txt.substring(i,i+m).equals(pat)) System.out.println("Found at "+i);
            if(i<n-m){
                t=(d*(t-txt.charAt(i)*h)+txt.charAt(i+m))%q;
                if(t<0) t+=q;
            }
        }
    }

    public static void main(String[] args) {
        search("abc", "abdabcbabc");
    }
}
