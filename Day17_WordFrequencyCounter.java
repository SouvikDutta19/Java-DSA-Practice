import java.util.*;

public class Day17_WordFrequencyCounter {
    public static void main(String[] args) {
        String text = "java is simple and java is powerful and java is versatile";
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : text.split(" ")) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
