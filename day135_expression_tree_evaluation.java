// day135_expression_tree_evaluation.java
// Build expression tree from postfix and evaluate

import java.util.*;

class ExprNode {
    String val;
    ExprNode left, right;
    ExprNode(String v) { val = v; }
}

public class day135_expression_tree_evaluation {
    static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    static ExprNode constructTree(String[] postfix) {
        Stack<ExprNode> st = new Stack<>();
        for (String token : postfix) {
            if (!isOperator(token)) {
                st.push(new ExprNode(token));
            } else {
                ExprNode node = new ExprNode(token);
                node.right = st.pop();
                node.left = st.pop();
                st.push(node);
            }
        }
        return st.peek();
    }

    static int evaluate(ExprNode root) {
        if (root == null) return 0;
        if (!isOperator(root.val)) return Integer.parseInt(root.val);
        int left = evaluate(root.left);
        int right = evaluate(root.right);
        return switch (root.val) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        // postfix expression: 3 4 + 2 * 7 /
        String[] postfix = {"3","4","+","2","*","7","/"};
        ExprNode root = constructTree(postfix);
        System.out.println("Result of expression: " + evaluate(root)); // (3+4)*2/7 = 2
    }
}
