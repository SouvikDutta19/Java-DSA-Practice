import java.util.Arrays;

public class Day13_ValidAnagramCheck {

    public static boolean isAnagram(String s1, String s2) {
        char[] a = s1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] b = s2.replaceAll("\\s", "").toLowerCase().toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        System.out.println(isAnagram(s1, s2) ? "✅ Anagram" : "❌ Not anagram");
    }
}
