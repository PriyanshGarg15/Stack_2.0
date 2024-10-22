import java.util.*;

public class a02_leetcode_496_next_greater_element_1 {
    public static void main(String[] args) {
        // Test case
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        
        int[] result = Solution.nextGreaterElement(nums1, nums2);
        
        // Print the result
        System.out.println(Arrays.toString(result));  // Output: [-1, 3, -1]
    }
}

class Solution {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ngr = nextGreaterRight(nums2);

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            hm.put(nums2[i], ngr[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = hm.get(nums1[i]);
        }

        return ans;
    }

    public static int[] nextGreaterRight(int[] nums) {
        Stack<Integer> st = new Stack<>();
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
