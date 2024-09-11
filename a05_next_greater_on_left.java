import java.util.*;
public class a5_next_greater_on_left {
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
            ans[i] = st.isEmpty() ? -1 : arr[st.peek()];
            st.push(i);
        }

        return ans;
    }
}
