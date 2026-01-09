public class day177_identical_binary_trees {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    public static boolean isIdentical(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return a.val == b.val
                && isIdentical(a.left, b.left)
                && isIdentical(a.right, b.right);
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);

        Node t2 = new Node(1);
        t2.left = new Node(2);
        t2.right = new Node(3);

        System.out.println("Identical Trees: " + isIdentical(t1, t2));
    }
}