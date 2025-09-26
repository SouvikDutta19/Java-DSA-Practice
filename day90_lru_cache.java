import java.util.*;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> map;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        return cache.get(key);
    }

    public void put(int key, int value) {
        cache.put(key, value);
        if (cache.size() > capacity) {
            int oldest = cache.keySet().iterator().next();
            cache.remove(oldest);
        }
    }
}

public class day90_lru_cache {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
    }
}
