import java.util.Stack;

public class ValidParenthesesChecker {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expr1 = "{[()]}";
        String expr2 = "{[(])}";
        System.out.println(expr1 + " is valid? " + isValid(expr1));
        System.out.println(expr2 + " is valid? " + isValid(expr2));
    }
}
