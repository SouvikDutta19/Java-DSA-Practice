public class Day13_ReverseWordsPreserveSpaces {

    public static String reverseWords(String input) {
        String[] words = input.trim().split(" +");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String sentence = "   Java    is   awesome  ";
        String reversed = reverseWords(sentence);
        System.out.println("🔁 Reversed: " + reversed);
    }
}
