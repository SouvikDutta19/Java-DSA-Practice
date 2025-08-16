class Node {
    int data;
    Node left, right, parent;
    boolean color; // true = Red, false = Black

    Node(int data) {
        this.data = data;
        left = right = parent = null;
        color = true;
    }
}

public class day47_red_black_tree {
    private Node root;

    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    private void rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != null) x.right.parent = y;
        x.parent = y.parent;
        if (y.parent == null) root = x;
        else if (y == y.parent.left) y.parent.left = x;
        else y.parent.right = x;
        x.right = y;
        y.parent = x;
    }

    private void fixInsert(Node z) {
        while (z.parent != null && z.parent.color) {
            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right;
                if (y != null && y.color) {
                    z.parent.color = false;
                    y.color = false;
                    z.parent.parent.color = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        rotateLeft(z);
                    }
                    z.parent.color = false;
                    z.parent.parent.color = true;
                    rotateRight(z.parent.parent);
                }
            } else {
                Node y = z.parent.parent.left;
                if (y != null && y.color) {
                    z.parent.color = false;
                    y.color = false;
                    z.parent.parent.color = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rotateRight(z);
                    }
                    z.parent.color = false;
                    z.parent.parent.color = true;
                    rotateLeft(z.parent.parent);
                }
            }
        }
        root.color = false;
    }

    public void insert(int data) {
        Node z = new Node(data);
        Node y = null, x = root;
        while (x != null) {
            y = x;
            if (z.data < x.data) x = x.left;
            else x = x.right;
        }
        z.parent = y;
        if (y == null) root = z;
        else if (z.data < y.data) y.left = z;
        else y.right = z;
        fixInsert(z);
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + (node.color ? "(R) " : "(B) "));
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        day47_red_black_tree tree = new day47_red_black_tree();
        int[] nums = {10, 20, 30, 15, 25, 5, 1};
        for (int num : nums) tree.insert(num);
        System.out.println("Inorder Traversal of Red-Black Tree:");
        tree.inorder(tree.root);
    }
}
