public class day57_doubly_linked_list {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    static class DoublyLinkedList {
        Node head, tail;

        void insertFront(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }

        void insertEnd(int data) {
            Node newNode = new Node(data);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        void delete(int data) {
            Node current = head;
            while (current != null && current.data != data) {
                current = current.next;
            }
            if (current == null) return;

            if (current == head) head = current.next;
            if (current == tail) tail = current.prev;
            if (current.prev != null) current.prev.next = current.next;
            if (current.next != null) current.next.prev = current.prev;
        }

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFront(10);
        dll.insertEnd(20);
        dll.insertEnd(30);
        dll.insertFront(5);
        dll.display();

        dll.delete(20);
        dll.display();
    }
}
