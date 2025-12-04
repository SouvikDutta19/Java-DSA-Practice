class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
    }
}

public class day154_linked_list_palindrome_check {

    Node head;

    void push(int d) {
        Node newNode = new Node(d);
        newNode.next = head;
        head = newNode;
    }

    boolean isPalindrome() {
        StringBuilder s1 = new StringBuilder();
        Node temp = head;

        while (temp != null) {
            s1.append(temp.data);
            temp = temp.next;
        }

        String s = s1.toString();
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public static void main(String[] args) {
        day154_linked_list_palindrome_check list = new day154_linked_list_palindrome_check();
        list.push(1);
        list.push(2);
        list.push(2);
        list.push(1);

        System.out.println("Is palindrome? " + list.isPalindrome());
    }
}