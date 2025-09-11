public class day72_segment_tree {
    static int[] tree,arr;
    static int n;

    static void build(int node,int l,int r){
        if(l==r){ tree[node]=arr[l]; return; }
        int mid=(l+r)/2;
        build(2*node,l,mid);
        build(2*node+1,mid+1,r);
        tree[node]=tree[2*node]+tree[2*node+1];
    }
    static int query(int node,int l,int r,int ql,int qr){
        if(ql>r || qr<l) return 0;
        if(ql<=l && r<=qr) return tree[node];
        int mid=(l+r)/2;
        return query(2*node,l,mid,ql,qr)+query(2*node+1,mid+1,r,ql,qr);
    }
    static void update(int node,int l,int r,int idx,int val){
        if(l==r){ tree[node]=val; return; }
        int mid=(l+r)/2;
        if(idx<=mid) update(2*node,l,mid,idx,val);
        else update(2*node+1,mid+1,r,idx,val);
        tree[node]=tree[2*node]+tree[2*node+1];
    }

    public static void main(String[] args){
        arr=new int[]{1,3,5,7,9,11}; n=arr.length;
        tree=new int[4*n];
        build(1,0,n-1);
        System.out.println("Query(1,3): "+query(1,0,n-1,1,3));
        update(1,0,n-1,1,10);
        System.out.println("After Update Query(1,3): "+query(1,0,n-1,1,3));
    }
}
