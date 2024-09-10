import java.util.Stack;

public class a26_postfix_to_prefix {

    // Function to check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Function to convert postfix expression to prefix expression
    public static String postfixToPrefix(String postfix) {
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
                String subExpression = ch + operand1 + operand2;
                stack.push(subExpression);
            }
        }

        // The last element of the stack will be the full prefix expression
        return stack.pop();
    }

    // Main method
    public static void main(String[] args) {
        String postfixExp = "pq+mn-*";
        String prefixExp = postfixToPrefix(postfixExp);
        System.out.println("Postfix expression: " + postfixExp);
        System.out.println("Prefix expression: " + prefixExp);
    }
}
