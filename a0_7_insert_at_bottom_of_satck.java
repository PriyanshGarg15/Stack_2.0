//do without using extra st !!
import java.util.Stack;

public class a0_7_insert_at_bottom_of_satck {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        System.out.println(st);
        insert(st, 0);
        System.out.println(st);
    }

    public static void insert(Stack<Integer> st, int item) {
        if (st.isEmpty()) {
            st.push(item);
            return;
        }

        // Pop all elements from the stack
        int top = st.pop();
        // Recursively insert the item at the bottom
        insert(st, item);
        // Push all the popped elements back onto the stack
        st.push(top);
    }
}
