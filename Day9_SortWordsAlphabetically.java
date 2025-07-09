import java.util.Arrays;
import java.util.Scanner;

public class Day9_SortWordsAlphabetically {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String[] words = sentence.toLowerCase().split("\\s+");
        Arrays.sort(words);

        System.out.println("🔤 Words sorted alphabetically:");
        for (String word : words) {
            System.out.println(word);
        }

        sc.close();
    }
}
