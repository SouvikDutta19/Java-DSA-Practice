public class day172_reverse_linked_list {

    static class Node {
        int val;
        Node next;
        Node(int v) { val = v; }
    }

    public static Node reverse(Node head) {
        Node prev = null, curr = head, next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // new head
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original List:");
        print(head);

        head = reverse(head);

        System.out.println("Reversed List:");
        print(head);
    }
}