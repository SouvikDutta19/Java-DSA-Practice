// Java program to implement LFU (Least Frequently Used) Cache
import java.util.*;

public class day38_implementlfucache {
    class Node {
        int key, val, freq;
        Node(int k, int v) {
            key = k; val = v; freq = 1;
        }
    }

    int capacity, minFreq;
    Map<Integer, Node> cache;
    Map<Integer, LinkedHashSet<Integer>> freqMap;

    public day38_implementlfucache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        updateFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            updateFreq(node);
        } else {
            if (cache.size() == capacity) {
                int evict = freqMap.get(minFreq).iterator().next();
                freqMap.get(minFreq).remove(evict);
                cache.remove(evict);
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            minFreq = 1;
            freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        }
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        freqMap.get(freq).remove(node.key);
        if (freq == minFreq && freqMap.get(freq).isEmpty())
            minFreq++;

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node.key);
    }

    public static void main(String[] args) {
        day38_implementlfucache cache = new day38_implementlfucache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1
        cache.put(3, 3); // Evicts 2
        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 3
    }
}
