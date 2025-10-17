// Program to implement LRU (Least Recently Used) Cache using LinkedHashMap

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

public class day110_lru_cache_implementation {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println("Cache after 3 inserts: " + cache);

        cache.get(1);
        cache.put(4, "D");

        System.out.println("Cache after accessing 1 and adding 4: " + cache);
    }
}
