import java.util.Stack;

public class Day12_CheckBalancedBrackets {

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else if (ch == ')' && (stack.isEmpty() || stack.pop() != '(')) return false;
            else if (ch == '}' && (stack.isEmpty() || stack.pop() != '{')) return false;
            else if (ch == ']' && (stack.isEmpty() || stack.pop() != '[')) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expr = "{[()]}";
        System.out.println(isBalanced(expr) ? "✅ Balanced" : "❌ Not Balanced");
    }
}
