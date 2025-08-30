// Program to build and evaluate an Expression Tree
import java.util.*;

class Node {
    String value;
    Node left, right;
    Node(String v) { value = v; left = right = null; }
}

public class day61_expressiontree {
    static boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    static Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();
        for (String token : postfix) {
            if (!isOperator(token)) {
                stack.push(new Node(token));
            } else {
                Node node = new Node(token);
                node.right = stack.pop();
                node.left = stack.pop();
                stack.push(node);
            }
        }
        return stack.peek();
    }

    static int evaluate(Node root) {
        if (root == null) return 0;
        if (!isOperator(root.value)) return Integer.parseInt(root.value);
        int left = evaluate(root.left);
        int right = evaluate(root.right);
        switch (root.value) {
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            case "/": return left / right;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] postfix = {"3", "4", "+", "2", "*", "7", "/"};
        Node root = buildTree(postfix);
        System.out.println("Result of expression: " + evaluate(root));
    }
}
