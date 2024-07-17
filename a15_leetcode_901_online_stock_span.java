import java.util.Arrays;
import java.util.Stack;

public class a15_leetcode_901_online_stock_span {
    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        Cal_Span(arr);
    }
    
    public static void Cal_Span(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[i] = i - st.peek();
            } else {
                ans[i] = i + 1;
            }
            st.push(i);
        }
        
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
