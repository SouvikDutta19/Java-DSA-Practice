import java.util.Scanner;

public class Day7_RemoveVowelsFromString {

    public static String removeVowels(String str) {
        return str.replaceAll("(?i)[aeiou]", "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = removeVowels(input);
        System.out.println("🧹 After removing vowels: " + result);

        sc.close();
    }
}
