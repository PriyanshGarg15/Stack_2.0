import java.util.Scanner;
import java.util.Stack;

public class a17_leetcode_20_valid_parentheses {
    public static boolean helper(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c == ']' && stack.peek() != '[') return false;
                if (c == ')' && stack.peek() != '(') return false;
                if (c == '}' && stack.peek() != '{') return false;
                else
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Boolean str=helper(s);
        System.out.println(str);
    }
}
