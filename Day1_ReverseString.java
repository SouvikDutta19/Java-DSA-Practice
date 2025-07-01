// package DailyPractice;

import java.util.Scanner;

/**
 * Day 1: Reverse a String (Clean, Efficient & Modular)
 * Author: Souvik Dutta
 *
 * Description:
 * This program reverses a given input string using an efficient two-pointer
 * approach and also provides alternate logic using StringBuilder for Java beginners.
 */

public class Day1_ReverseString {

    /**
     * Reverses a string using the two-pointer technique (manual method).
     *
     * @param input The string to reverse
     * @return The reversed string
     */
    public static String reverseUsingTwoPointer(String input) {
        if (input == null || input.length() <= 1) return input;

        char[] chars = input.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            // Swap characters at left and right indexes
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }

    /**
     * Reverses a string using Java's StringBuilder (simpler but less 'manual').
     *
     * @param input The string to reverse
     * @return The reversed string
     */
    public static String reverseUsingStringBuilder(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔁 Enter a string to reverse:");
        String input = scanner.nextLine();

        System.out.println("\n✅ Reversed using Two-Pointer logic:");
        System.out.println(reverseUsingTwoPointer(input));

        System.out.println("\n✅ Reversed using StringBuilder:");
        System.out.println(reverseUsingStringBuilder(input));

        scanner.close();
    }
}
