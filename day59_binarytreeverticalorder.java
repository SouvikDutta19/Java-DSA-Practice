import java.util.*;

class BinaryTreeVerticalOrder {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Pair {
        Node node;
        int hd;
        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    public static void verticalOrder(Node root) {
        if (root == null) return;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            Node node = temp.node;
            int hd = temp.hd;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.data);

            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Vertical Order Traversal:");
        verticalOrder(root);
    }
}
