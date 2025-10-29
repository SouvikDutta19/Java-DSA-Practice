// day122_lfucacheoptimized.java
import java.util.*;

public class day122_lfucacheoptimized {
    static class Node {
        int key, value, freq;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; freq = 1; }
    }

    static class DoublyLinkedList {
        Node head, tail;
        int size = 0;
        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        void add(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    static class LFUCache {
        int capacity, minFreq;
        Map<Integer, Node> keyMap;
        Map<Integer, DoublyLinkedList> freqMap;

        LFUCache(int capacity) {
            this.capacity = capacity;
            keyMap = new HashMap<>();
            freqMap = new HashMap<>();
            minFreq = 0;
        }

        public int get(int key) {
            if (!keyMap.containsKey(key)) return -1;
            Node node = keyMap.get(key);
            update(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            if (keyMap.containsKey(key)) {
                Node node = keyMap.get(key);
                node.value = value;
                update(node);
                return;
            }
            if (keyMap.size() == capacity) {
                DoublyLinkedList minList = freqMap.get(minFreq);
                Node toRemove = minList.removeLast();
                keyMap.remove(toRemove.key);
            }
            Node newNode = new Node(key, value);
            keyMap.put(key, newNode);
            freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).add(newNode);
            minFreq = 1;
        }

        private void update(Node node) {
            int freq = node.freq;
            DoublyLinkedList list = freqMap.get(freq);
            list.remove(node);
            if (freq == minFreq && list.size == 0) minFreq++;
            node.freq++;
            freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).add(node);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
