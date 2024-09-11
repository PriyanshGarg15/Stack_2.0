import java.util.Stack;

public class a8_reverse_stack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        
        System.out.println("Original stack: " + st);
        
        reverse(st);
        
        System.out.println("Reversed stack: " + st);
    }

    public static void reverse(Stack<Integer> st) {
        if (!st.isEmpty()) {
            // Remove the top element from the stack
            int item = st.pop();
            // Recursively reverse the remaining stack
            reverse(st);
            // Insert the removed element at the bottom of the reversed stack
            insertAtBottom(st, item);
        }
    }

    public static void insertAtBottom(Stack<Integer> st, int item) {
        if (st.isEmpty()) {
            // If stack is empty, push the item
            st.push(item);
        } else {
            // Remove top element and insert at bottom
            int top = st.pop();
            insertAtBottom(st, item);
            // Push removed item back to top
            st.push(top);
        }
    }
}
