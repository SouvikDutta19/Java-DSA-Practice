class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}

public class Day17_ReverseLinkedList {
    static Node reverse(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("Original:");
        printList(head);

        head = reverse(head);
        System.out.println("\nReversed:");
        printList(head);
    }
}
