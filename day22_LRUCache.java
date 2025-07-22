import java.util.*;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> map;
    private final Deque<Integer> deque;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.deque = new LinkedList<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        deque.remove(key);
        deque.addFirst(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            deque.remove(key);
        } else if(deque.size() == capacity) {
            int last = deque.removeLast();
            map.remove(last);
        }
        deque.addFirst(key);
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));   // 1
        cache.put(3, 3);
        System.out.println(cache.get(2));   // -1
        cache.put(4, 4);
        System.out.println(cache.get(1));   // -1
        System.out.println(cache.get(3));   // 3
        System.out.println(cache.get(4));   // 4
    }
}
