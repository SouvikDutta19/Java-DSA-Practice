import java.util.*;

class TreapNode {
    int key, priority;
    TreapNode left, right;

    TreapNode(int key) {
        this.key = key;
        this.priority = new Random().nextInt(100);
        left = right = null;
    }
}

public class day44_treap {
    TreapNode root;

    TreapNode rightRotate(TreapNode y) {
        TreapNode x = y.left;
        TreapNode T2 = x.right;
        x.right = y;
        y.left = T2;
        return x;
    }

    TreapNode leftRotate(TreapNode x) {
        TreapNode y = x.right;
        TreapNode T2 = y.left;
        y.left = x;
        x.right = T2;
        return y;
    }

    TreapNode insert(TreapNode root, int key) {
        if (root == null)
            return new TreapNode(key);

        if (key <= root.key) {
            root.left = insert(root.left, key);
            if (root.left.priority > root.priority)
                root = rightRotate(root);
        } else {
            root.right = insert(root.right, key);
            if (root.right.priority > root.priority)
                root = leftRotate(root);
        }
        return root;
    }

    void inorder(TreapNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        day44_treap t = new day44_treap();
        t.root = t.insert(t.root, 50);
        t.root = t.insert(t.root, 30);
        t.root = t.insert(t.root, 20);
        t.root = t.insert(t.root, 40);
        t.root = t.insert(t.root, 70);
        t.root = t.insert(t.root, 60);
        t.root = t.insert(t.root, 80);

        System.out.println("Inorder traversal of Treap:");
        t.inorder(t.root);
    }
}
