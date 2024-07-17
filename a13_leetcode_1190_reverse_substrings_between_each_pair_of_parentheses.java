import java.util.*;

public class a13_leetcode_1190_reverse_substrings_between_each_pair_of_parentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String ans = reverse_order(str);
        System.out.println(ans);
    }

    public static String reverse_order(String str) {
        Stack<Character> st=new Stack<>();
        Queue<Character> queue=new LinkedList<>();
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='(')
            {
                st.push('(');
            }
            else if(str.charAt(i)==')')
            {
                while(st.peek()!='(')
                {
                    queue.add(st.pop());
                }
                st.pop();
                while (!queue.isEmpty()) {
                    st.push(queue.poll());
                }
            }
            else
            {
                st.push(str.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character c : st) {
            result.append(c);
        }

        return result.toString();

    }
}
