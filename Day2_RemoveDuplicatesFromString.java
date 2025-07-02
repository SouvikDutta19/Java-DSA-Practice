import java.util.LinkedHashSet;
import java.util.Scanner;

public class Day2_RemoveDuplicatesFromString {

    // Removes duplicate characters while preserving order
    public static String removeDuplicates(String input) {
        if (input == null || input.isEmpty()) return input;

        LinkedHashSet<Character> seen = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to remove duplicate characters: ");
        String input = scanner.nextLine();

        String cleaned = removeDuplicates(input);
        System.out.println("🔡 Original: " + input);
        System.out.println("✅ Without Duplicates: " + cleaned);

        scanner.close();
    }
}
