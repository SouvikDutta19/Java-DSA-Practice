// day138_merge_k_sorted_lists.java
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class day138_merge_k_sorted_lists {

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode node : lists)
            if (node != null) pq.add(node);

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = node;

            if (node.next != null)
                pq.add(node.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1); a.next = new ListNode(4);
        ListNode b = new ListNode(2); b.next = new ListNode(5);

        ListNode[] lists = {a, b};
        ListNode merged = mergeKLists(lists);

        System.out.print("Merged List: ");
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}
