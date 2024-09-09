import java.util.Stack;

public class a24_infix_to_prefix {

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

    // Checks if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Reverse a string
    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    // Replace '(' with ')' and vice versa
    private static String replaceParentheses(String exp) {
        char[] chars = exp.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                chars[i] = ')';
            } else if (chars[i] == ')') {
                chars[i] = '(';
            }
        }
        return new String(chars);
    }

    // Converts an infix expression to postfix
    private static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char ch = exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Converts an infix expression to prefix
    public static String infixToPrefix(String exp) {
        String reversed = reverseString(exp);
        String modified = replaceParentheses(reversed);
        String postfix = infixToPostfix(modified);
        return reverseString(postfix);
    }

    // Main method
    public static void main(String[] args) {
        String infixExp = "(p+q)*(m-n)";
        String prefixExp = infixToPrefix(infixExp);
        System.out.println("Infix expression: " + infixExp);
        System.out.println("Prefix expression: " + prefixExp);
    }
}
