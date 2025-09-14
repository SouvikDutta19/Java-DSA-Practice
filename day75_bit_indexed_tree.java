public class day75_bit_indexed_tree {
    static int[] BIT;
    static int n;

    static void update(int idx,int val){
        while(idx<=n){
            BIT[idx]+=val;
            idx+=idx&-idx;
        }
    }

    static int query(int idx){
        int sum=0;
        while(idx>0){
            sum+=BIT[idx];
            idx-=idx&-idx;
        }
        return sum;
    }

    public static void main(String[] args){
        int[] arr={1,2,3,4,5};
        n=arr.length;
        BIT=new int[n+1];
        for(int i=0;i<n;i++) update(i+1,arr[i]);
        System.out.println("Prefix sum(3): "+query(3));
    }
}
