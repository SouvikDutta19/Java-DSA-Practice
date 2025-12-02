public class day152_flattenbinarytree {

    static class Node {
        int data;
        Node left, right;
        Node(int d) { data = d; }
    }

    public static void flatten(Node root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        Node left = root.left;
        Node right = root.right;

        root.left = null;
        root.right = left;

        Node temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }

        temp.right = right;
    }

    public static void print(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        flatten(root);

        System.out.print("Flattened Tree: ");
        print(root);
    }
}
