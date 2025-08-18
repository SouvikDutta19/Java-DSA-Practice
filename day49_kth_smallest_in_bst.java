class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class day49_kth_smallest_in_bst {
    static int count = 0;

    static Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data) root.left = insert(root.left, data);
        else root.right = insert(root.right, data);
        return root;
    }

    static void kthSmallest(Node root, int k) {
        if (root == null) return;
        kthSmallest(root.left, k);
        count++;
        if (count == k) {
            System.out.println("Kth Smallest Element: " + root.data);
            return;
        }
        kthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        Node root = null;
        int[] keys = {20, 8, 22, 4, 12, 10, 14};
        for (int key : keys) root = insert(root, key);

        int k = 3;
        kthSmallest(root, k);
    }
}
