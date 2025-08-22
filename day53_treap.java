import java.util.*;

public class day53_treap {
    static class Node {
        int key, priority;
        Node left, right;
        Node(int key) {
            this.key = key;
            this.priority = new Random().nextInt(100);
        }
    }

    static Node root;

    public static Node rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        return x;
    }

    public static Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    public static Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key <= root.key) {
            root.left = insert(root.left, key);
            if (root.left.priority > root.priority) root = rotateRight(root);
        } else {
            root.right = insert(root.right, key);
            if (root.right.priority > root.priority) root = rotateLeft(root);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);

        System.out.print("Inorder traversal of Treap: ");
        inorder(root);
    }
}
