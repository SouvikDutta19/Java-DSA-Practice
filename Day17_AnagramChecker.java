import java.util.Arrays;

public class Day17_AnagramChecker {
    public static boolean isAnagram(String s1, String s2) {
        char[] a1 = s1.toLowerCase().toCharArray();
        char[] a2 = s2.toLowerCase().toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        System.out.println("Are anagrams? " + isAnagram(s1, s2));
    }
}
