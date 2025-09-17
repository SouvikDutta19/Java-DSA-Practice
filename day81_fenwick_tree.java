public class day81_fenwick_tree {
    int[] BIT; int n;

    public day81_fenwick_tree(int n){
        this.n=n; BIT=new int[n+1];
    }

    void update(int idx,int val){
        for(;idx<=n;idx+=idx&-idx) BIT[idx]+=val;
    }

    int query(int idx){
        int sum=0;
        for(;idx>0;idx-=idx&-idx) sum+=BIT[idx];
        return sum;
    }

    public static void main(String[] args){
        day81_fenwick_tree ft=new day81_fenwick_tree(6);
        int[] arr={1,2,3,4,5,6};
        for(int i=0;i<arr.length;i++) ft.update(i+1,arr[i]);
        System.out.println("Sum(1,3): "+(ft.query(3)-ft.query(0)));
    }
}
