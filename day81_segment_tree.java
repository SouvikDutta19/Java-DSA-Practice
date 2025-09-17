public class day81_segment_tree {
    int[] segtree; int n;

    public day81_segment_tree(int[] arr) {
        n=arr.length;
        segtree=new int[4*n];
        build(arr,0,n-1,1);
    }

    void build(int[] arr,int l,int r,int idx) {
        if(l==r){segtree[idx]=arr[l];return;}
        int mid=(l+r)/2;
        build(arr,l,mid,2*idx);
        build(arr,mid+1,r,2*idx+1);
        segtree[idx]=segtree[2*idx]+segtree[2*idx+1];
    }

    int query(int idx,int l,int r,int ql,int qr) {
        if(ql>r || qr<l) return 0;
        if(ql<=l && r<=qr) return segtree[idx];
        int mid=(l+r)/2;
        return query(2*idx,l,mid,ql,qr)+query(2*idx+1,mid+1,r,ql,qr);
    }

    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,11};
        day81_segment_tree st=new day81_segment_tree(arr);
        System.out.println("Sum(1,3): "+st.query(1,0,arr.length-1,1,3));
    }
}
