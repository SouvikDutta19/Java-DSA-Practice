import java.util.Scanner;

public class Day11_ReverseEachWordInSentence {

    public static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        System.out.println("🔁 Reversed Words: " + reverseWords(sentence));
        sc.close();
    }
}
