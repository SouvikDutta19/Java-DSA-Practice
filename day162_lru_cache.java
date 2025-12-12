// Day162 - LRU Cache Implementation (HashMap + Doubly Linked List)
import java.util.*;

public class day162_lru_cache {

    static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCache {
        private final int capacity;
        private final Map<Integer, Node> map = new HashMap<>();
        private final Node head = new Node(-1, -1);
        private final Node tail = new Node(-1, -1);

        LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        private void addFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;

            Node node = map.get(key);
            removeNode(node);
            addFront(node);

            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;

                removeNode(node);
                addFront(node);
                return;
            }

            if (map.size() == capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            addFront(newNode);
            map.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);

        System.out.println(cache.get(1)); // 10

        cache.put(4, 40); // removes key 2 (least recently used)

        System.out.println(cache.get(2)); // -1 (removed)
        System.out.println(cache.get(3)); // 30
        System.out.println(cache.get(4)); // 40
    }
}