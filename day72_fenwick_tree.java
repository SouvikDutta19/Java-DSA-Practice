public class day72_fenwick_tree {
    static int[] bit; static int n;

    static void update(int idx,int val){ for(;idx<=n;idx+=idx&-idx) bit[idx]+=val; }
    static int query(int idx){ int sum=0; for(;idx>0;idx-=idx&-idx) sum+=bit[idx]; return sum; }

    public static void main(String[] args){
        int[] arr={1,2,3,4,5};
        n=arr.length; bit=new int[n+1];
        for(int i=0;i<n;i++) update(i+1,arr[i]);
        System.out.println("Sum[1..3]: "+query(3));
        update(2,2);
        System.out.println("After update Sum[1..3]: "+query(3));
    }
}
