import java.util.Scanner;

public class Day1_CountVowels {

    /**
     * Counts the number of vowels in the given string.
     *
     * @param str The input string
     * @return Number of vowels found
     */
    public static int countVowels(String str) {
        if (str == null || str.isEmpty()) return 0;

        int count = 0;
        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("📝 Enter a string to count vowels: ");
        String input = scanner.nextLine();

        int result = countVowels(input);
        System.out.println("🔢 Total vowels: " + result);

        scanner.close();
    }
}
