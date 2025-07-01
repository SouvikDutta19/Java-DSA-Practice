import java.util.Scanner;

public class Day1_CheckPalindrome {

    /**
     * Checks whether a given string is a palindrome.
     * Ignores non-alphanumeric characters and case sensitivity.
     *
     * @param str The input string
     * @return true if it's a palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return false;

        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔍 Enter a string to check for palindrome:");
        String input = scanner.nextLine();

        if (isPalindrome(input))
            System.out.println("✅ It is a palindrome!");
        else
            System.out.println("❌ Not a palindrome.");

        scanner.close();
    }
}
