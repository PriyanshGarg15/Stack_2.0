import java.util.*;
public class a15_duplicate_brackets {
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the expression to check for duplicate brackets:");
        String n = sc.nextLine();
        boolean hasDuplicate = false;
        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            
            if (ch == ')') {
                if (st.peek() == '(') {
                    hasDuplicate = true;
                    break;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop(); 
                }
            } 
            else 
            {
                st.push(ch);
            }
        }
        if (hasDuplicate) {
            System.out.println("The expression contains duplicate brackets.");
        } else {
            System.out.println("The expression does not contain duplicate brackets.");
        }
    }
}
