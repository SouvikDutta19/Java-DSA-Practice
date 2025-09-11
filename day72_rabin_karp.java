public class day72_rabin_karp {
    static void search(String pat,String txt,int q){
        int m=pat.length(),n=txt.length();
        int d=256,h=1,p=0,t=0;
        for(int i=0;i<m-1;i++) h=(h*d)%q;
        for(int i=0;i<m;i++){ p=(d*p+pat.charAt(i))%q; t=(d*t+txt.charAt(i))%q; }
        for(int i=0;i<=n-m;i++){
            if(p==t && txt.substring(i,i+m).equals(pat)) System.out.println("Found at "+i);
            if(i<n-m){ t=(d*(t-txt.charAt(i)*h)+txt.charAt(i+m))%q; if(t<0) t+=q; }
        }
    }

    public static void main(String[] args){
        search("aba","abacadabra",101);
    }
}
