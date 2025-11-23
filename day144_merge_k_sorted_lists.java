import java.util.*;

class NodeK {
    int data;
    NodeK next;
    NodeK(int d) { data = d; }
}

public class day144_merge_k_sorted_lists {

    public static NodeK mergeKLists(NodeK[] lists) {
        PriorityQueue<NodeK> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));

        for (NodeK node : lists)
            if (node != null)
                pq.add(node);

        NodeK dummy = new NodeK(0);
        NodeK tail = dummy;

        while (!pq.isEmpty()) {
            NodeK min = pq.poll();
            tail.next = min;
            tail = tail.next;

            if (min.next != null)
                pq.add(min.next);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        NodeK a = new NodeK(1); a.next = new NodeK(4); a.next.next = new NodeK(7);
        NodeK b = new NodeK(2); b.next = new NodeK(5); b.next.next = new NodeK(8);
        NodeK c = new NodeK(3); c.next = new NodeK(6); c.next.next = new NodeK(9);

        NodeK[] lists = {a, b, c};

        NodeK res = mergeKLists(lists);

        System.out.println("Merged List:");
        while (res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
    }
}
