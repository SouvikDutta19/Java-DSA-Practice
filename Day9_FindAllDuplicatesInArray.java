import java.util.*;

public class Day9_FindAllDuplicatesInArray {

    public static List<Integer> findDuplicates(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1)
                duplicates.add(entry.getKey());
        }

        return duplicates;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        List<Integer> duplicates = findDuplicates(arr);
        System.out.println("🔁 Duplicates in array: " + (duplicates.isEmpty() ? "None" : duplicates));

        sc.close();
    }
}
