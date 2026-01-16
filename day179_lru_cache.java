import java.util.*;

public class day179_lru_cache {

    static class LRUCache {
        int capacity;
        LinkedHashMap<Integer, Integer> map;

        LRUCache(int cap) {
            capacity = cap;
            map = new LinkedHashMap<>(cap, 0.75f, true);
        }

        int get(int key) {
            return map.getOrDefault(key, -1);
        }

        void put(int key, int value) {
            if (map.size() == capacity && !map.containsKey(key)) {
                int lru = map.entrySet().iterator().next().getKey();
                map.remove(lru);
            }
            map.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.get(1);
        cache.put(3, 30);

        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 30
    }
}