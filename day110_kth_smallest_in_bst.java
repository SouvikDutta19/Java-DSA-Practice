// Program to find the Kth smallest element in a Binary Search Tree

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class day110_kth_smallest_in_bst {
    static int count = 0;

    public static Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.data) root.left = insert(root.left, key);
        else root.right = insert(root.right, key);
        return root;
    }

    public static Node kthSmallest(Node root, int k) {
        if (root == null) return null;

        Node left = kthSmallest(root.left, k);

        if (left != null) return left;

        count++;
        if (count == k) return root;

        return kthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        int[] keys = {50, 30, 70, 20, 40, 60, 80};
        Node root = null;
        for (int key : keys)
            root = insert(root, key);

        int k = 3;
        Node result = kthSmallest(root, k);
        if (result != null)
            System.out.println(k + "rd smallest element is " + result.data);
        else
            System.out.println("Less than k elements in the tree");
    }
}
