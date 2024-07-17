import java.util.*;

public class a6_leetcode_503_next_grater_element_2 {
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        // Traverse from second last to the first element
        for (int i = nums.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }
            st.push(nums[i]);
        }
        
        int[] ans = new int[nums.length];
        
        // Traverse from the last to the first element
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(nums[i]);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1}; // Test case
        int[] result = nextGreaterElements(nums);
        System.out.println(Arrays.toString(result)); // Expected output: [2, -1, 2]
    }
}
