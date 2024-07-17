import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class a14_leetcode_1249_Minimum_Remove_to_Make_Valid_Parentheses {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        // Add any remaining '(' indexes in the stack to the set of indexes to remove
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }

        // Build the result string without the indexes marked for removal
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        a14_leetcode_1249_Minimum_Remove_to_Make_Valid_Parentheses solution = new a14_leetcode_1249_Minimum_Remove_to_Make_Valid_Parentheses();
        String s = "lee(t(c)o)de)";
        System.out.println(solution.minRemoveToMakeValid(s)); // Output: "lee(t(c)o)de"

        s = "a)b(c)d";
        System.out.println(solution.minRemoveToMakeValid(s)); // Output: "ab(c)d"

        s = "))((";
        System.out.println(solution.minRemoveToMakeValid(s)); // Output: ""
    }
}
