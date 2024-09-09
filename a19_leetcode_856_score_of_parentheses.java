import java.util.*;

public class a19_leetcode_856_score_of_parentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int ans = scoreOfParentheses(str);
        System.out.println(ans);
    }
    
    public static int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(-1); // Push -1 to signify the start of a new segment
            } else { // c == ')'
                if (stack.peek() == -1) {
                    stack.pop(); // Remove the -1
                    stack.push(1); // Push 1 for "()" case
                } else {
                    int sum = 0;
                    while (stack.peek() != -1) {
                        sum += stack.pop(); // Accumulate nested scores
                    }
                    stack.pop(); // Remove the -1
                    stack.push(2 * sum); // Push the computed score for the current segment
                }
            }
        }
        
        int totalScore = 0;

        //supoose end meh (...) aisa nahi heh balki ()() in this case out stack have 1 1 so we need to calculate its sum and give it!
         while (!stack.isEmpty()) {
            totalScore += stack.pop(); // Accumulate all scores on the stack
        }
        
        return totalScore;
    }
}
