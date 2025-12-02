import java.util.*;

public class day152_lrucache {

    static class LRUCache {
        private LinkedHashMap<Integer, Integer> map;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new LinkedHashMap<>(capacity, 0.75f, true) {
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            map.put(key, value);
        }

        public String toString() {
            return map.toString();
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.get(1);  
        cache.put(4, 40);  
        
        System.out.println("LRU Cache: " + cache);
    }
}
