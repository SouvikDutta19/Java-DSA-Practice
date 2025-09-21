import java.util.*;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> map;
    private final LinkedHashSet<Integer> order;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.order = new LinkedHashSet<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        order.remove(key);
        order.add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            order.remove(key);
        } else if (map.size() == capacity) {
            int oldest = order.iterator().next();
            order.remove(oldest);
            map.remove(oldest);
        }
        map.put(key, value);
        order.add(key);
    }

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
