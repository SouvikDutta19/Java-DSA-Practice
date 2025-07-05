import java.util.Arrays;
import java.util.Scanner;

public class Day5_CheckAnagramStrings {

    public static boolean isAnagram(String str1, String str2) {
        char[] a = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] b = str2.replaceAll("\\s", "").toLowerCase().toCharArray();

        if (a.length != b.length) return false;

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String first = sc.nextLine();

        System.out.print("Enter second string: ");
        String second = sc.nextLine();

        if (isAnagram(first, second)) {
            System.out.println("✅ The strings are anagrams.");
        } else {
            System.out.println("❌ The strings are not anagrams.");
        }

        sc.close();
    }
}
