// day122_lru_cache_linkedhashmap.java
import java.util.*;

public class day122_lru_cache_linkedhashmap {
    static class LRUCache extends LinkedHashMap<Integer, Integer> {
        private final int capacity;
        LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }
        public int get(int key) {
            return super.getOrDefault(key, -1);
        }
        public void putKey(int key, int value) {
            super.put(key, value);
        }
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.putKey(1, 1);
        cache.putKey(2, 2);
        System.out.println(cache.get(1)); // 1
        cache.putKey(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // -1
        cache.putKey(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}
