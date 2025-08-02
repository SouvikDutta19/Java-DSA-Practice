import java.util.*;

public class day33_lru_cache {
    static class LRUCache {
        int capacity;
        Map<Integer, Integer> map;
        Deque<Integer> deque;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.deque = new LinkedList<>();
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;

            deque.remove(key);
            deque.addFirst(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                deque.remove(key);
            } else if (deque.size() == capacity) {
                int last = deque.removeLast();
                map.remove(last);
            }
            deque.addFirst(key);
            map.put(key, value);
        }

        public void display() {
            for (int key : deque)
                System.out.print(key + ":" + map.get(key) + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);
        cache.display();
        cache.get(2);
        cache.put(4, 400);
        cache.display(); // Expected: 4 2 3
    }
}
