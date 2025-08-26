public class day57_circular_linked_list {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class CircularLinkedList {
        Node head = null, tail = null;

        void insert(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                newNode.next = head;
            } else {
                tail.next = newNode;
                tail = newNode;
                tail.next = head;
            }
        }

        void display() {
            if (head == null) return;
            Node temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(1);
        cll.insert(2);
        cll.insert(3);
        cll.insert(4);
        cll.display();
    }
}
