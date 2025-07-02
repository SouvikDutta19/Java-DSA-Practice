import java.util.Arrays;
import java.util.Scanner;

public class Day2_AnagramCheck {

    public static boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) return false;

        char[] a = str1.toLowerCase().toCharArray();
        char[] b = str2.toLowerCase().toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first word: ");
        String word1 = scanner.nextLine();
        System.out.print("Enter second word: ");
        String word2 = scanner.nextLine();

        if (areAnagrams(word1, word2)) {
            System.out.println("✅ \"" + word1 + "\" and \"" + word2 + "\" are anagrams.");
        } else {
            System.out.println("❌ \"" + word1 + "\" and \"" + word2 + "\" are NOT anagrams.");
        }

        scanner.close();
    }
}
