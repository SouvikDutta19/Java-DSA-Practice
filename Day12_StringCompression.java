public class Day12_StringCompression {

    public static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            int count = 1;
            while (i + 1 < str.length() && str.charAt(i + 1) == ch) {
                count++;
                i++;
            }
            sb.append(ch);
            if (count > 1) sb.append(count);
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "aaabbcccdee";
        System.out.println("🧵 Compressed: " + compress(input));
    }
}
