import java.util.*;

// Huffman Encoding using Priority Queue
class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;
    Node(char c, int f) { ch = c; freq = f; }
    public int compareTo(Node o) { return this.freq - o.freq; }
}

public class day108_huffman_encoding {
    static void printCodes(Node root, String s) {
        if (root == null) return;
        if (root.ch != '-') System.out.println(root.ch + ": " + s);
        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freq = {5, 9, 12, 13, 16, 45};
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < chars.length; i++)
            pq.add(new Node(chars[i], freq[i]));
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node newNode = new Node('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;
            pq.add(newNode);
        }
        printCodes(pq.peek(), "");
    }
}
