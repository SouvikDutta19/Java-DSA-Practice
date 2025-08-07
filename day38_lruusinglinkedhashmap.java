// LRU Cache implementation using LinkedHashMap

import java.util.*;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

public class day38_lruusinglinkedhashmap {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println("Cache: " + cache);

        cache.get(2);
        cache.put(4, "Four");
        System.out.println("After access and add: " + cache);

        cache.get(1); // Not present
        cache.put(5, "Five");
        System.out.println("Final Cache: " + cache);
    }
}
