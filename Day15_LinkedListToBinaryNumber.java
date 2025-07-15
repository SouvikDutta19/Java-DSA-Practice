class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class Day15_LinkedListToBinaryNumber {

    public static int getDecimalValue(Node head) {
        int result = 0;
        while (head != null) {
            result = (result << 1) | head.val;
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(1);

        System.out.println("🔢 Decimal value of binary in linked list: " + getDecimalValue(head));
    }
}
