// Day148 Segment Tree for range sum and point update
public class Day148SegmentTree {
    static class SegTree {
        int n;
        int[] tree;
        SegTree(int[] arr){
            n = arr.length;
            tree = new int[4*n];
            build(arr,1,0,n-1);
        }
        void build(int[] a, int node, int l, int r){
            if(l==r){ tree[node]=a[l]; return; }
            int mid=(l+r)/2;
            build(a,node*2,l,mid);
            build(a,node*2+1,mid+1,r);
            tree[node] = tree[node*2] + tree[node*2+1];
        }
        void update(int idx, int val){ update(1,0,n-1,idx,val); }
        void update(int node,int l,int r,int idx,int val){
            if(l==r){ tree[node]=val; return;}
            int mid=(l+r)/2;
            if(idx<=mid) update(node*2,l,mid,idx,val);
            else update(node*2+1,mid+1,r,idx,val);
            tree[node]=tree[node*2]+tree[node*2+1];
        }
        int query(int L,int R){ return query(1,0,n-1,L,R); }
        int query(int node,int l,int r,int L,int R){
            if(R<l||r<L) return 0;
            if(L<=l && r<=R) return tree[node];
            int mid=(l+r)/2;
            return query(node*2,l,mid,L,R) + query(node*2+1,mid+1,r,L,R);
        }
    }

    public static void main(String[] args){
        int[] arr = {1,3,5,7,9,11};
        SegTree st = new SegTree(arr);
        System.out.println("Sum(1..3) = " + st.query(1,3)); // 3+5+7=15
        st.update(1,10); // arr[1]=10
        System.out.println("After update Sum(1..3) = " + st.query(1,3)); // 10+5+7=22
    }
}
