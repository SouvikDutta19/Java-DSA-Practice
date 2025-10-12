import java.util.*;

// Treap (randomized BST) with insert, delete and inorder traversal
public class day106_treap {
    static class Node {
        int key, priority;
        Node left, right;
        Node(int k) {
            key = k;
            priority = new Random().nextInt();
        }
    }

    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        return x;
    }

    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        return y;
    }

    static Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.key) {
            root.left = insert(root.left, key);
            if (root.left.priority > root.priority) root = rightRotate(root);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
            if (root.right.priority > root.priority) root = leftRotate(root);
        }
        return root;
    }

    static Node delete(Node root, int key) {
        if (root == null) return root;
        if (key < root.key) root.left = delete(root.left, key);
        else if (key > root.key) root.right = delete(root.right, key);
        else {
            if (root.left == null) root = root.right;
            else if (root.right == null) root = root.left;
            else if (root.left.priority < root.right.priority) {
                root = leftRotate(root);
                root.left = delete(root.left, key);
            } else {
                root = rightRotate(root);
                root.right = delete(root.right, key);
            }
        }
        return root;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + "(" + root.priority + ") ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        int[] keys = {50, 30, 20, 40, 70, 60, 80};
        for (int k : keys) root = insert(root, k);
        System.out.print("Inorder after inserts: ");
        inorder(root);
        System.out.println();
        root = delete(root, 50);
        System.out.print("Inorder after deleting 50: ");
        inorder(root);
        System.out.println();
    }
}
