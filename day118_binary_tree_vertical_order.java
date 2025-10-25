import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int data) { this.data = data; }
}

public class day118_binary_tree_vertical_order {

    static void printVerticalOrder(Node root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Map.Entry<Node, Integer>> q = new LinkedList<>();
        q.add(new AbstractMap.SimpleEntry<>(root, 0));

        while (!q.isEmpty()) {
            Map.Entry<Node, Integer> temp = q.poll();
            Node node = temp.getKey();
            int hd = temp.getValue();

            map.computeIfAbsent(hd, k -> new ArrayList<>()).add(node.data);

            if (node.left != null)
                q.add(new AbstractMap.SimpleEntry<>(node.left, hd - 1));
            if (node.right != null)
                q.add(new AbstractMap.SimpleEntry<>(node.right, hd + 1));
        }

        for (ArrayList<Integer> list : map.values())
            System.out.println(list);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        printVerticalOrder(root);
    }
}
