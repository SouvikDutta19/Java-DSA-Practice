// day114_segment_tree_lazy.java
// Segment Tree with range addition updates and range sum queries (lazy propagation).
import java.util.*;
class Main {
    static class SegmentTree {
        int n;
        long[] tree, lazy;
        SegmentTree(int n){
            this.n = n;
            tree = new long[4*n];
            lazy = new long[4*n];
        }
        void build(int idx, int l, int r, long[] arr){
            if(l==r){ tree[idx]=arr[l]; return; }
            int mid=(l+r)>>1;
            build(idx<<1,l,mid,arr);
            build(idx<<1|1,mid+1,r,arr);
            tree[idx]=tree[idx<<1]+tree[idx<<1|1];
        }
        void apply(int idx, int l, int r, long val){
            tree[idx] += val * (r-l+1);
            lazy[idx] += val;
        }
        void push(int idx, int l, int r){
            if(lazy[idx]!=0){
                int mid=(l+r)>>1;
                apply(idx<<1, l, mid, lazy[idx]);
                apply(idx<<1|1, mid+1, r, lazy[idx]);
                lazy[idx]=0;
            }
        }
        void update(int idx, int l, int r, int ql, int qr, long val){
            if(ql>r || qr<l) return;
            if(ql<=l && r<=qr){ apply(idx,l,r,val); return; }
            push(idx,l,r);
            int mid=(l+r)>>1;
            update(idx<<1,l,mid,ql,qr,val);
            update(idx<<1|1,mid+1,r,ql,qr,val);
            tree[idx]=tree[idx<<1]+tree[idx<<1|1];
        }
        long query(int idx, int l, int r, int ql, int qr){
            if(ql>r || qr<l) return 0;
            if(ql<=l && r<=qr) return tree[idx];
            push(idx,l,r);
            int mid=(l+r)>>1;
            return query(idx<<1,l,mid,ql,qr) + query(idx<<1|1,mid+1,r,ql,qr);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextLong();
        SegmentTree st = new SegmentTree(n);
        st.build(1,0,n-1,arr);
        int q = sc.nextInt();
        while(q-- > 0){
            String type = sc.next();
            if(type.equals("update")){
                int l = sc.nextInt(), r = sc.nextInt();
                long val = sc.nextLong();
                st.update(1,0,n-1,l,r,val);
            } else if(type.equals("query")){
                int l = sc.nextInt(), r = sc.nextInt();
                System.out.println(st.query(1,0,n-1,l,r));
            }
        }
        sc.close();
    }
}
