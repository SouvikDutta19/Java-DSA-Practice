public class Day186DetectCycleLinkedList {

    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    public static boolean hasCycle(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = head;

        System.out.println(hasCycle(head));
    }
}