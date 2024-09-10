import java.util.Stack;

public class a23_infix_to_postfix {

    // Returns the precedence of the given operator
    private static int getPrecedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    // Converts the given infix expression to postfix expression
    private static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char ch = exp.charAt(i);

            // If the character is an operand, add it to result
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } 
            // If the character is '(', push it to stack
            else if (ch == '(') {
                stack.push(ch);
            } 
            // If the character is ')', pop and append from stack until '(' is encountered
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove '(' from stack
            } 
            // If the character is an operator
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Checks if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Main method
    public static void main(String[] args) {
        String infixExp = "(p+q)*(m-n)";
        String postfixExp = infixToPostfix(infixExp);
        System.out.println("Infix expression: " + infixExp);
        System.out.println("Postfix expression: " + postfixExp);
    }
}
