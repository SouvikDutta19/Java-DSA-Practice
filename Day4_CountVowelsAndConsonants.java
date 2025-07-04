import java.util.Scanner;

public class Day4_CountVowelsAndConsonants {

    public static void countVowelsConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) >= 0) vowels++;
                else consonants++;
            }
        }

        System.out.println("🟢 Vowels: " + vowels);
        System.out.println("🔵 Consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        countVowelsConsonants(input);

        sc.close();
    }
}
