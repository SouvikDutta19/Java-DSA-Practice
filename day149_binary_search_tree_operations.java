// Day149 BST: Insert, Search, Delete, Inorder Traversal
public class Day149BinarySearchTreeOperations {
    static class Node {
        int key;
        Node left, right;
        Node(int k){ key = k; }
    }

    public static Node insert(Node root, int key){
        if(root == null) return new Node(key);
        if(key < root.key) root.left = insert(root.left, key);
        else root.right = insert(root.right, key);
        return root;
    }

    public static boolean search(Node root, int key){
        if(root == null) return false;
        if(root.key == key) return true;
        return key < root.key ? search(root.left, key) : search(root.right, key);
    }

    public static Node delete(Node root, int key){
        if(root == null) return null;
        if(key < root.key) root.left = delete(root.left, key);
        else if(key > root.key) root.right = delete(root.right, key);
        else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            Node succ = root.right;
            while(succ.left != null) succ = succ.left;
            root.key = succ.key;
            root.right = delete(root.right, succ.key);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    public static void main(String[] args){
        Node root = null;
        int[] vals = {50,30,20,40,70,60,80};
        for(int v: vals) root = insert(root, v);

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        System.out.println("Search 60: " + search(root,60));
        System.out.println("Search 25: " + search(root,25));

        root = delete(root, 20);
        System.out.print("After deleting 20: ");
        inorder(root);
        System.out.println();
    }
}
