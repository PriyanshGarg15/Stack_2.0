import java.util.Stack;

public class a27_prefix_to_infix {

    // Function to check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Function to convert prefix expression to infix expression
    public static String prefixToInfix(String prefix) {
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
                String subExpression = "(" + operand1 + ch + operand2 + ")";
                stack.push(subExpression);
            }
        }

        // The last element of the stack will be the full infix expression
        return stack.pop();
    }

    // Main method
    public static void main(String[] args) {
        String prefixExp = "*+pq-mn";
        String infixExp = prefixToInfix(prefixExp);
        System.out.println("Prefix expression: " + prefixExp);
        System.out.println("Infix expression: " + infixExp);
    }
}
