import java.util.*;

public class day144_lru_cache {

    static class LRUCache extends LinkedHashMap<Integer, Integer> {
        int capacity;

        LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.get(1);
        cache.put(4, 40);

        System.out.println("Cache Content:");
        cache.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
