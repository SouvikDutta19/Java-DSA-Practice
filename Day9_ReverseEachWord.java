import java.util.Scanner;

public class Day9_ReverseEachWord {

    public static String reverseWords(String str) {
        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String reversed = reverseWords(input);
        System.out.println("🔁 Sentence with reversed words: " + reversed);

        sc.close();
    }
}
