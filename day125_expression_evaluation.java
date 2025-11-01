import java.util.*;

public class day125_expression_evaluation {

    static int evaluate(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == ' ') continue;

            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    val = val * 10 + (expression.charAt(i++) - '0');
                }
                values.push(val);
                i--;
            } else if (ch == '(') {
                ops.push(ch);
            } else if (ch == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            } else if ("+-*/".indexOf(ch) != -1) {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(ch))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.push(ch);
            }
        }
        while (!ops.isEmpty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        return values.pop();
    }

    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    static int applyOp(char op, int b, int a) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        System.out.println("Result: " + evaluate("10 + 2 * 6"));
        System.out.println("Result: " + evaluate("100 * ( 2 + 12 ) / 14"));
    }
}
