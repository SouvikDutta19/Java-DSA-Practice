public class day20_longestValidParentheses {
    public static int longestValidParentheses(String s) {
        int max = 0;
        int left = 0, right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else right++;
            if (left == right) max = Math.max(max, 2 * right);
            else if (right > left) left = right = 0;
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') right++;
            else left++;
            if (left == right) max = Math.max(max, 2 * left);
            else if (left > right) left = right = 0;
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "(()))())(";
        System.out.println("Longest Valid Parentheses: " + longestValidParentheses(s));
    }
}
