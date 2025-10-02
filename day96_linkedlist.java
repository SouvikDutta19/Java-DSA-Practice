class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}

public class day96_linkedlist {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        day96_linkedlist list = new day96_linkedlist();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        System.out.print("Linked list: ");
        list.printList();
    }
}
