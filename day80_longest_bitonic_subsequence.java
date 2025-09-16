public class day80_longest_bitonic_subsequence {
    public static int longestBitonicSubsequence(int[] arr,int n) {
        int[] lis=new int[n], lds=new int[n];
        for(int i=0;i<n;i++) {
            lis[i]=1;
            for(int j=0;j<i;j++) if(arr[i]>arr[j]) lis[i]=Math.max(lis[i],lis[j]+1);
        }
        for(int i=n-1;i>=0;i--) {
            lds[i]=1;
            for(int j=n-1;j>i;j--) if(arr[i]>arr[j]) lds[i]=Math.max(lds[i],lds[j]+1);
        }
        int max=0;
        for(int i=0;i<n;i++) max=Math.max(max,lis[i]+lds[i]-1);
        return max;
    }

    public static void main(String[] args) {
        int[] arr={1,11,2,10,4,5,2,1};
        System.out.println("Longest Bitonic Subsequence: " + longestBitonicSubsequence(arr,arr.length));
    }
}
