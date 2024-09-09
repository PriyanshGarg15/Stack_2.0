import java.util.*;

public class a3_leetcode_503_next_grater_element_2 {

    public static class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> st = new Stack<>();
            
            for (int i = nums.length - 2; i >= 0; i--) {
                st.push(nums[i]);
            }

            int[] ans = new int[nums.length];
            
            for (int i = nums.length - 1; i >= 0; i--) {
                while (!st.isEmpty() && st.peek() <= nums[i]) {
                    st.pop();
                }
                ans[i] = st.isEmpty() ? -1 : st.peek();
                st.push(nums[i]);
            }
            
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1}; 
        Solution sol = new Solution();
        int[] result = sol.nextGreaterElements(nums);
        System.out.println(Arrays.toString(result));
    }
}
