import java.util.*;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> map;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        return cache.get(key);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}

public class day46_lruCache {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        System.out.println("Get 2: " + lru.get(2));
        lru.put(4, 4);
        System.out.println("Get 1: " + lru.get(1)); // should be -1 as 1 is removed
        System.out.println("Get 3: " + lru.get(3));
    }
}
