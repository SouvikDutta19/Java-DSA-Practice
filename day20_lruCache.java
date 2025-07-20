import java.util.*;

public class day20_lruCache {
    private final int capacity;
    private final Map<Integer, Integer> map;
    private final LinkedList<Integer> order;

    public day20_lruCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.order = new LinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        order.remove((Integer) key);
        order.addFirst(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) order.remove((Integer) key);
        else if (order.size() == capacity) {
            int removed = order.removeLast();
            map.remove(removed);
        }
        order.addFirst(key);
        map.put(key, value);
    }

    public static void main(String[] args) {
        day20_lruCache cache = new day20_lruCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
    }
}
