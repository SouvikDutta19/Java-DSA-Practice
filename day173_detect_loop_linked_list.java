public class day173_detect_loop_linked_list {

    static class Node {
        int val;
        Node next;
        Node(int v){ val = v; }
    }

    public static boolean hasLoop(Node head) {
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head; // loop created
        System.out.println("Loop exists: " + hasLoop(head));
    }
}