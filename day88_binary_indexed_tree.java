class BIT {
    int[] tree;
    int n;

    BIT(int n) {
        this.n = n;
        tree = new int[n+1];
    }

    void update(int i, int val) {
        for (; i<=n; i+=i&-i) tree[i]+=val;
    }

    int query(int i) {
        int sum=0;
        for (; i>0; i-=i&-i) sum+=tree[i];
        return sum;
    }
}

public class day88_binary_indexed_tree {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        BIT bit = new BIT(arr.length);
        for (int i=0;i<arr.length;i++) bit.update(i+1, arr[i]);
        System.out.println("Prefix sum (1..3): " + bit.query(3));
        bit.update(2, 5);
        System.out.println("Prefix sum (1..3) after update: " + bit.query(3));
    }
}
