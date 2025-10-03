class BSTNode {
    int key;
    BSTNode left, right;

    public BSTNode(int item) {
        key = item;
        left = right = null;
    }
}

public class day97_bstimplementation {
    BSTNode root;

    day97_bstimplementation() { root = null; }

    void insert(int key) { root = insertRec(root, key); }

    BSTNode insertRec(BSTNode root, int key) {
        if (root == null) return new BSTNode(key);
        if (key < root.key) root.left = insertRec(root.left, key);
        else if (key > root.key) root.right = insertRec(root.right, key);
        return root;
    }

    void inorder() { inorderRec(root); }

    void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        day97_bstimplementation tree = new day97_bstimplementation();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inorder();
    }
}
