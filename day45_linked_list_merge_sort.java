class LinkedListMergeSort {
    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    Node head;

    Node sortedMerge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.data <= b.data) {
            a.next = sortedMerge(a.next, b);
            return a;
        } else {
            b.next = sortedMerge(a, b.next);
            return b;
        }
    }

    Node getMiddle(Node h) {
        if (h == null) return h;
        Node slow = h, fast = h.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    Node mergeSort(Node h) {
        if (h == null || h.next == null) return h;
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(h);
        Node right = mergeSort(nextofmiddle);

        return sortedMerge(left, right);
    }

    void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList(Node headref) {
        while (headref != null) {
            System.out.print(headref.data + " ");
            headref = headref.next;
        }
    }

    public static void main(String[] args) {
        LinkedListMergeSort list = new LinkedListMergeSort();
        list.push(15);
        list.push(10);
        list.push(5);
        list.push(20);
        list.push(3);
        list.push(2);

        list.head = list.mergeSort(list.head);
        list.printList(list.head);
    }
}
