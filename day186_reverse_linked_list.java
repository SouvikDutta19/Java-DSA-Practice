public class Day186ReverseLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static Node reverse(Node head) {
        Node prev = null, curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        print(head);
        head = reverse(head);
        print(head);
    }
}