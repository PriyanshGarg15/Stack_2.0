import java.util.Stack;

public class a10_leetcode_901_online_stock_span {

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        calculateSpan(arr);
    }

    public static void calculateSpan(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        for (int span : ans) {
            System.out.print(span + " ");
        }
    }
}
