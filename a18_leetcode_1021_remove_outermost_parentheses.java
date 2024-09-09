import java.util.*;

public class a18_leetcode_1021_remove_outermost_parentheses 
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String ans=removeoutermost(str);
        System.out.println(ans);
    }
    public static  String removeoutermost(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (!stack.isEmpty()) {
                    sb.append(c);
                }
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
    
}
