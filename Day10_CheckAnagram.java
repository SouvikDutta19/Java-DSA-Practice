import java.util.Arrays;
import java.util.Scanner;

public class Day10_CheckAnagram {

    public static boolean isAnagram(String str1, String str2) {
        char[] s1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] s2 = str2.replaceAll("\\s", "").toLowerCase().toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        if (isAnagram(s1, s2))
            System.out.println("✅ The strings are anagrams.");
        else
            System.out.println("❌ The strings are not anagrams.");

        sc.close();
    }
}
