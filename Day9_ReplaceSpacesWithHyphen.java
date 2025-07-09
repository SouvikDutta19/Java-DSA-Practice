import java.util.Scanner;

public class Day9_ReplaceSpacesWithHyphen {

    public static String replaceSpaces(String str) {
        return str.trim().replaceAll("\\s+", "-");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String modified = replaceSpaces(input);
        System.out.println("🔧 Modified string: " + modified);

        sc.close();
    }
}
