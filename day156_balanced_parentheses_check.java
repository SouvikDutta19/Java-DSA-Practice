import java.util.*;

public class day156_balanced_parentheses_check {

    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);

            else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '['))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[()]}";

        System.out.println("Is Balanced? " + isBalanced(s));
    }
}