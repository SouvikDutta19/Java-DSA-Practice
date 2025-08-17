class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class day48_binary_tree_to_dll {
    Node root;
    Node head;
    static Node prev = null;

    void convertToDLL(Node node) {
        if (node == null) return;

        convertToDLL(node.left);

        if (prev == null) {
            head = node;
        } else {
            node.left = prev;
            prev.right = node;
        }
        prev = node;

        convertToDLL(node.right);
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public static void main(String[] args) {
        day48_binary_tree_to_dll tree = new day48_binary_tree_to_dll();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        tree.convertToDLL(tree.root);
        System.out.println("Doubly Linked List:");
        tree.printList(tree.head);
    }
}
