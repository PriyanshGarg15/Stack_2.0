import java.util.Arrays;
import java.util.Stack;

public class a2_next_greater_on_left {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 6, 11, 9, 6};
        int[] result = nextGreaterElementOnLeft(arr);
        System.out.println(Arrays.toString(result)); // Expected output: [-1, 5, 3, 5, -1, -1, 11, 9]
    }

    public static int[] nextGreaterElementOnLeft(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = arr[st.peek()];
            }
            st.push(i);
        }

        return ans;
    }
}
