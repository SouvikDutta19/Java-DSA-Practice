public class day184_kth_smallest_bst {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static int count = 0, result = -1;

    static void inorder(Node root, int k) {
        if (root == null) return;

        inorder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);

        inorder(root, 3);
        System.out.println(result);
    }
}