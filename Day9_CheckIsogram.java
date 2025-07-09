import java.util.HashSet;
import java.util.Scanner;

public class Day9_CheckIsogram {

    public static boolean isIsogram(String str) {
        HashSet<Character> set = new HashSet<>();
        str = str.toLowerCase();

        for (char c : str.toCharArray()) {
            if (set.contains(c)) return false;
            if (Character.isLetter(c)) set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = sc.nextLine();

        if (isIsogram(word))
            System.out.println("✅ The word is an Isogram (no repeating letters)");
        else
            System.out.println("❌ The word is not an Isogram");

        sc.close();
    }
}
