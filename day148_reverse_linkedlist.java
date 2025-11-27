// Day148 Reverse Linked List (iterative & recursive)
public class Day148ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v){val = v;}
    }

    // Iterative reverse
    public static ListNode reverseIterative(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Recursive reverse
    public static ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    // Helper to print list
    static void print(ListNode h){
        while(h!=null){
            System.out.print(h.val + (h.next!=null?" -> ":""));
            h = h.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);

        System.out.print("Original: ");
        print(n);

        ListNode it = reverseIterative(n);
        System.out.print("Iterative reversed: ");
        print(it);

        ListNode rec = reverseRecursive(it);
        System.out.print("Recursive reversed back: ");
        print(rec);
    }
}
