public class day116_floyd_cycle_detection {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static boolean detectCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // cycle

        System.out.println(detectCycle(head) ? "Cycle detected" : "No cycle");
    }
}
