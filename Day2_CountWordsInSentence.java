import java.util.Scanner;

public class Day2_CountWordsInSentence {

    // Counts number of words in a sentence using space detection
    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }

        // Split by one or more spaces
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();

        int wordCount = countWords(input);
        System.out.println("📝 Total words: " + wordCount);

        scanner.close();
    }
}
