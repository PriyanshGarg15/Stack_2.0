import java.util.Stack;

public class a28_prefix_to_postfix {

    // Function to check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Function to convert prefix expression to postfix expression
    public static String prefixToPostfix(String prefix) {
        Stack<String> stack = new Stack<>();

        // Traverse the prefix expression from right to left
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);

            // If the character is an operand, push it to the stack
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            }
            // If the character is an operator, pop two elements from the stack
            else if (isOperator(ch)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String subExpression = operand1 + operand2 + ch;
                stack.push(subExpression);
            }
        }

        // The last element of the stack will be the full postfix expression
        return stack.pop();
    }

    // Main method
    public static void main(String[] args) {
        String prefixExp = "*+pq-mn";
        String postfixExp = prefixToPostfix(prefixExp);
        System.out.println("Prefix expression: " + prefixExp);
        System.out.println("Postfix expression: " + postfixExp);
    }
}
