import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class day155_merge_k_sorted_lists {

    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;

            if (node.next != null)
                pq.add(node.next);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(5);

        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};
        ListNode head = mergeKLists(lists);

        System.out.print("Merged K Sorted Lists: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}