import java.util.*;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> map;
    private final LinkedList<Integer> lru;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.lru = new LinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        lru.remove((Integer) key);
        lru.addFirst(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            lru.remove((Integer) key);
        } else if (lru.size() == capacity) {
            int oldKey = lru.removeLast();
            map.remove(oldKey);
        }
        lru.addFirst(key);
        map.put(key, value);
    }
}

public class day37_lru_cache_implementation {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
