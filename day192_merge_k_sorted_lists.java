import java.util.PriorityQueue;

public class Day192MergeKSortedLists {

    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    public static Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (Node node : lists)
            if (node != null)
                pq.add(node);

        Node dummy = new Node(0);
        Node curr = dummy;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null)
                pq.add(node.next);
        }

        return dummy.next;
    }
}