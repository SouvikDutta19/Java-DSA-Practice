// day140_longest_valid_parentheses.java

import java.util.*;

public class day140_longest_valid_parentheses {

    public static int longestValid(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "(()())";
        System.out.println(longestValid(str));
    }
}
