// day135_lru_cache_design.java
// LRU Cache using LinkedHashMap

import java.util.*;

public class day135_lru_cache_design {
    static class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;
        LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }
        public int getKey(int key) { return super.getOrDefault(key, -1); }
        public void putKey(int key, int value) { super.put(key, value); }
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.putKey(1,1);
        cache.putKey(2,2);
        System.out.println(cache.getKey(1)); // 1
        cache.putKey(3,3); // evicts key 2
        System.out.println(cache.getKey(2)); // -1
        cache.putKey(4,4); // evicts key 1
        System.out.println(cache.getKey(1)); // -1
        System.out.println(cache.getKey(3)); // 3
        System.out.println(cache.getKey(4)); // 4
    }
}
