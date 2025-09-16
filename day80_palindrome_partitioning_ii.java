public class day80_palindrome_partitioning_ii {
    public static int minCut(String s) {
        int n=s.length();
        boolean[][] isPal=new boolean[n][n];
        int[] cuts=new int[n];
        for(int i=0;i<n;i++) {
            int min=i;
            for(int j=0;j<=i;j++) {
                if(s.charAt(i)==s.charAt(j) && (i-j<2 || isPal[j+1][i-1])) {
                    isPal[j][i]=true;
                    min=j==0?0:Math.min(min,cuts[j-1]+1);
                }
            }
            cuts[i]=min;
        }
        return cuts[n-1];
    }

    public static void main(String[] args) {
        System.out.println("Min Cuts for Palindrome Partitioning: " + minCut("aab"));
    }
}
