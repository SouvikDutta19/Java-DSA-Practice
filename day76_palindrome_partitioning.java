public class day76_palindrome_partitioning {
    static int minCuts(String str){
        int n=str.length();
        boolean[][] pal=new boolean[n][n];
        int[] cuts=new int[n];
        for(int i=0;i<n;i++){
            int minCut=i;
            for(int j=0;j<=i;j++){
                if(str.charAt(i)==str.charAt(j) && (i-j<=1 || pal[j+1][i-1])){
                    pal[j][i]=true;
                    minCut=(j==0)?0:Math.min(minCut,cuts[j-1]+1);
                }
            }
            cuts[i]=minCut;
        }
        return cuts[n-1];
    }
    public static void main(String[] args){
        String s="ababbbabbababa";
        System.out.println("Min cuts: "+minCuts(s));
    }
}
