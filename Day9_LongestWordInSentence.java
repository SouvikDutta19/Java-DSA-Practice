import java.util.Scanner;

public class Day9_LongestWordInSentence {

    public static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+");
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String longestWord = findLongestWord(sentence);
        System.out.println("📏 Longest word: " + longestWord);
        System.out.println("Length: " + longestWord.length());

        sc.close();
    }
}
