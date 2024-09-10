import java.util.Stack;

public class a25_postfix_to_infix {

    // Function to check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Function to convert postfix expression to infix expression
    public static String postfixToInfix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            // If the character is an operand, push it to the stack
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            }
            // If the character is an operator, pop two elements from the stack
            else if (isOperator(ch)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String subExpression = "(" + operand1 + ch + operand2 + ")";
                stack.push(subExpression);
            }
        }

        // The last element of the stack will be the full infix expression
        return stack.pop();
    }

    // Main method
    public static void main(String[] args) {
        String postfixExp = "pq+mn-*";
        String infixExp = postfixToInfix(postfixExp);
        System.out.println("Postfix expression: " + postfixExp);
        System.out.println("Infix expression: " + infixExp);
    }
}
