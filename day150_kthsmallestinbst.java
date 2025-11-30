public class day150_kthsmallestinbst {

    static class Node {
        int data;
        Node left, right;
        Node(int d) { data = d; }
    }

    static class KthTracker {
        int count = 0;
        int result = -1;
    }

    public static void kthSmallest(Node root, int k, KthTracker tracker) {
        if (root == null) return;

        kthSmallest(root.left, k, tracker);

        tracker.count++;
        if (tracker.count == k) {
            tracker.result = root.data;
            return;
        }

        kthSmallest(root.right, k, tracker);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);

        int k = 3;
        KthTracker tracker = new KthTracker();
        kthSmallest(root, k, tracker);

        System.out.println(k + "rd smallest element = " + tracker.result);
    }
}
