// Day148 LRU Cache using LinkedHashMap
import java.util.*;

public class Day148LruCache {
    static class LRUCache {
        private final int capacity;
        private final LinkedHashMap<Integer, Integer> map;

        LRUCache(int capacity){
            this.capacity = capacity;
            this.map = new LinkedHashMap<>(capacity, 0.75f, true){
                protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                    return size() > LRUCache.this.capacity;
                }
            };
        }
        public int get(int key){
            return map.getOrDefault(key, -1);
        }
        public void put(int key, int value){
            map.put(key, value);
        }
        public String toString(){
            return map.toString();
        }
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache(3);
        cache.put(1,100);
        cache.put(2,200);
        cache.put(3,300);
        System.out.println(cache);
        cache.get(1); // access 1
        cache.put(4,400); // evict least recently used (2)
        System.out.println("After accessing 1 and adding 4: " + cache);
        System.out.println("Get 2 -> " + cache.get(2)); // -1
    }
}
