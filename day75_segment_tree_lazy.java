import java.util.*;

public class day75_segment_tree_lazy {
    static int[] tree, lazy;
    static int n;

    static void build(int[] arr, int node, int start, int end){
        if(start==end) tree[node]=arr[start];
        else{
            int mid=(start+end)/2;
            build(arr,node*2,start,mid);
            build(arr,node*2+1,mid+1,end);
            tree[node]=tree[node*2]+tree[node*2+1];
        }
    }

    static void updateRange(int node,int start,int end,int l,int r,int val){
        if(lazy[node]!=0){
            tree[node]+=(end-start+1)*lazy[node];
            if(start!=end){
                lazy[node*2]+=lazy[node];
                lazy[node*2+1]+=lazy[node];
            }
            lazy[node]=0;
        }
        if(start>r||end<l) return;
        if(start>=l && end<=r){
            tree[node]+=(end-start+1)*val;
            if(start!=end){
                lazy[node*2]+=val;
                lazy[node*2+1]+=val;
            }
            return;
        }
        int mid=(start+end)/2;
        updateRange(node*2,start,mid,l,r,val);
        updateRange(node*2+1,mid+1,end,l,r,val);
        tree[node]=tree[node*2]+tree[node*2+1];
    }

    static int query(int node,int start,int end,int l,int r){
        if(start>r||end<l) return 0;
        if(lazy[node]!=0){
            tree[node]+=(end-start+1)*lazy[node];
            if(start!=end){
                lazy[node*2]+=lazy[node];
                lazy[node*2+1]+=lazy[node];
            }
            lazy[node]=0;
        }
        if(start>=l && end<=r) return tree[node];
        int mid=(start+end)/2;
        return query(node*2,start,mid,l,r)+query(node*2+1,mid+1,end,l,r);
    }

    public static void main(String[] args){
        int[] arr={1,2,3,4,5};
        n=arr.length;
        tree=new int[4*n];
        lazy=new int[4*n];
        build(arr,1,0,n-1);
        updateRange(1,0,n-1,1,3,2);
        System.out.println("Query(0,4): "+query(1,0,n-1,0,4));
    }
}
