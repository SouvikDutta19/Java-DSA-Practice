import java.util.*;

// LRU Cache implementation using LinkedHashMap
public class day105_lru_cache {
    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    public day105_lru_cache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        day105_lru_cache lru = new day105_lru_cache(3);
        lru.put(1, 10);
        lru.put(2, 20);
        lru.put(3, 30);
        System.out.println(lru.get(1));
        lru.put(4, 40);
        System.out.println(lru.get(2));
    }
}
