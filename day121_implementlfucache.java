// day121_implementlfucache.java
import java.util.*;

public class day121_implementlfucache {
    static class LFUCache {
        private final int capacity;
        private int minFreq;
        private Map<Integer, Integer> keyToVal;
        private Map<Integer, Integer> keyToFreq;
        private Map<Integer, LinkedHashSet<Integer>> freqToKeys;

        LFUCache(int capacity) {
            this.capacity = capacity;
            keyToVal = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKeys = new HashMap<>();
            minFreq = 0;
        }

        public int get(int key) {
            if (!keyToVal.containsKey(key)) return -1;
            updateFrequency(key);
            return keyToVal.get(key);
        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            if (keyToVal.containsKey(key)) {
                keyToVal.put(key, value);
                updateFrequency(key);
                return;
            }
            if (keyToVal.size() >= capacity) {
                int evict = freqToKeys.get(minFreq).iterator().next();
                freqToKeys.get(minFreq).remove(evict);
                keyToVal.remove(evict);
                keyToFreq.remove(evict);
            }
            keyToVal.put(key, value);
            keyToFreq.put(key, 1);
            freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
            minFreq = 1;
        }

        private void updateFrequency(int key) {
            int freq = keyToFreq.get(key);
            freqToKeys.get(freq).remove(key);
            keyToFreq.put(key, freq + 1);
            freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
            if (freqToKeys.get(freq).isEmpty() && freq == minFreq)
                minFreq++;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
    }
}
