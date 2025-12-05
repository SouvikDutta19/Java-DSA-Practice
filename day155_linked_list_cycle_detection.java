class NodeCycle {
    int data;
    NodeCycle next;

    NodeCycle(int d) {
        data = d;
    }
}

public class day155_linked_list_cycle_detection {

    NodeCycle head;

    void push(int d) {
        NodeCycle newNode = new NodeCycle(d);
        newNode.next = head;
        head = newNode;
    }

    boolean detectCycle() {
        NodeCycle slow = head;
        NodeCycle fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        day155_linked_list_cycle_detection list = new day155_linked_list_cycle_detection();

        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);

        list.head.next.next.next.next = list.head; // Creating a cycle

        System.out.println("Cycle detected? " + list.detectCycle());
    }
}