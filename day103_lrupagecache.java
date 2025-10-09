import java.util.*;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache;
    private final Deque<Integer> order;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.order = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            System.out.println("Key " + key + " not found!");
            return -1;
        }
        order.remove(key);
        order.addFirst(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            order.remove(key);
        } else if (cache.size() == capacity) {
            int leastUsed = order.removeLast();
            cache.remove(leastUsed);
            System.out.println("Removed least recently used key: " + leastUsed);
        }
        cache.put(key, value);
        order.addFirst(key);
        System.out.println("Inserted (" + key + ", " + value + ")");
    }

    public void display() {
        System.out.println("Cache state: " + order);
    }
}

public class day103_lrupagecache {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.put(1, 10);
        lru.put(2, 20);
        lru.put(3, 30);
        lru.display();

        lru.get(1);
        lru.put(4, 40);
        lru.display();

        lru.get(2);
        lru.display();
    }
}
