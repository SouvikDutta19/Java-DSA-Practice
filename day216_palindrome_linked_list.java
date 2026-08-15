public class day216_palindrome_linked_list {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean isPalindrome(
            ListNode head) {

        if (head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null &&
               fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf =
                reverse(slow);

        ListNode firstHalf = head;

        while (secondHalf != null) {

            if (firstHalf.val != secondHalf.val)
                return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    static ListNode reverse(ListNode head) {

        ListNode prev = null;

        while (head != null) {

            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}