public class day75_rabin_karp {
    static final int d=256, q=101;

    static void search(String pat,String txt){
        int m=pat.length(), n=txt.length();
        int i,j,p=0,t=0,h=1;
        for(i=0;i<m-1;i++) h=(h*d)%q;
        for(i=0;i<m;i++){
            p=(d*p+pat.charAt(i))%q;
            t=(d*t+txt.charAt(i))%q;
        }
        for(i=0;i<=n-m;i++){
            if(p==t){
                for(j=0;j<m;j++) if(txt.charAt(i+j)!=pat.charAt(j)) break;
                if(j==m) System.out.println("Found at index "+i);
            }
            if(i<n-m){
                t=(d*(t-txt.charAt(i)*h)+txt.charAt(i+m))%q;
                if(t<0) t+=q;
            }
        }
    }

    public static void main(String[] args){
        search("abc","abdabcbabc");
    }
}
