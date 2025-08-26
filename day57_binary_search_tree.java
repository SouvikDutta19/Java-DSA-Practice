public class day57_binary_search_tree {
    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }

    static class BST {
        Node root;

        Node insert(Node root, int key) {
            if (root == null) return new Node(key);
            if (key < root.key) root.left = insert(root.left, key);
            else if (key > root.key) root.right = insert(root.right, key);
            return root;
        }

        void inorder(Node root) {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.key + " ");
                inorder(root.right);
            }
        }

        Node search(Node root, int key) {
            if (root == null || root.key == key) return root;
            return key < root.key ? search(root.left, key) : search(root.right, key);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 20);
        bst.insert(bst.root, 40);
        bst.insert(bst.root, 60);
        bst.insert(bst.root, 80);

        System.out.print("Inorder Traversal: ");
        bst.inorder(bst.root);

        System.out.println("\nSearch for 60: " + (bst.search(bst.root, 60) != null));
        System.out.println("Search for 90: " + (bst.search(bst.root, 90) != null));
    }
}
