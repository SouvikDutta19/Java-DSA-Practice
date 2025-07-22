import java.util.*;

public class ExpressionEvaluator {
    public static int evaluate(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isWhitespace(ch)) continue;
            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i)))
                    val = val * 10 + (expression.charAt(i++) - '0');
                values.push(val);
                i--;
            } else if (ch == '(') {
                ops.push(ch);
            } else if (ch == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            } else if (isOperator(ch)) {
                while (!ops.isEmpty() && precedence(ch) <= precedence(ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.push(ch);
            }
        }

        while (!ops.isEmpty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    private static boolean isOperator(char op) {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }

    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    private static int applyOp(char op, int b, int a) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        String expr = "(2+3)*(4+5)";
        System.out.println("Result: " + evaluate(expr));
    }
}
