import java.util.Scanner;

public class Day3_ReverseWordsInSentence {

    public static String reverseWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) return sentence;
        String[] words = sentence.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) reversed.append(" ");
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String result = reverseWords(input);
        System.out.println("🔁 Reversed Sentence: " + result);

        sc.close();
    }
}
