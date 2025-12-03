public class day153_removeduplicatesll {

    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    public static Node removeDuplicates(Node head) {
        Node cur = head;

        while (cur != null && cur.next != null) {
            if (cur.data == cur.next.data)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }

        return head;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(10);
        head.next.next = new Node(20);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(30);

        head = removeDuplicates(head);
        print(head);
    }
}