import java.util.*;

public class Day14_LRUCacheSimulation {

    static class LRUCache {
        private final int capacity;
        private final LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new LinkedHashMap<>(capacity, 0.75f, true);
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            map.put(key, value);
            if (map.size() > capacity) {
                map.remove(map.keySet().iterator().next());
            }
        }

        public void display() {
            System.out.println("📋 Cache contents: " + map);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);
        cache.get(1);
        cache.put(4, 400);
        cache.display();
    }
}
