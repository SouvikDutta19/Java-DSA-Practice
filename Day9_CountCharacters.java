import java.util.Scanner;

public class Day9_CountCharacters {

    public static int countCharacters(String str) {
        return str.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int count = countCharacters(input);
        System.out.println("🔢 Total characters: " + count);

        sc.close();
    }
}
