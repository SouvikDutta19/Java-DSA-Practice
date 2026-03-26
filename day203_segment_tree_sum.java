public class day203_segment_tree_sum {

    int[] tree;
    int n;

    public day203_segment_tree_sum(int[] nums){
        n = nums.length;
        tree = new int[4*n];
        build(nums,0,0,n-1);
    }

    void build(int[] nums, int node, int start, int end){

        if(start == end){
            tree[node] = nums[start];
        }
        else{
            int mid = (start + end) / 2;

            build(nums,2*node+1,start,mid);
            build(nums,2*node+2,mid+1,end);

            tree[node] = tree[2*node+1] + tree[2*node+2];
        }
    }

    public int query(int l, int r){
        return queryUtil(0,0,n-1,l,r);
    }

    int queryUtil(int node,int start,int end,int l,int r){

        if(r < start || l > end)
            return 0;

        if(l <= start && end <= r)
            return tree[node];

        int mid = (start + end) / 2;

        return queryUtil(2*node+1,start,mid,l,r)
             + queryUtil(2*node+2,mid+1,end,l,r);
    }

    public void update(int idx, int val){
        updateUtil(0,0,n-1,idx,val);
    }

    void updateUtil(int node,int start,int end,int idx,int val){

        if(start == end){
            tree[node] = val;
        }
        else{
            int mid = (start + end) / 2;

            if(idx <= mid)
                updateUtil(2*node+1,start,mid,idx,val);
            else
                updateUtil(2*node+2,mid+1,end,idx,val);

            tree[node] = tree[2*node+1] + tree[2*node+2];
        }
    }
}