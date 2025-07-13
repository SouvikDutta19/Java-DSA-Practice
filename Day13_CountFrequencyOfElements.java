import java.util.HashMap;

public class Day13_CountFrequencyOfElements {

    public static void countFrequency(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println("📊 Frequency of elements:");
        for (int key : map.keySet()) {
            System.out.println(key + " → " + map.get(key));
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 4, 3, 5, 1};
        countFrequency(arr);
    }
}
