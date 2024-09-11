import java.util.Stack;

public class a32_leetcode_2104_sum_of_subarray_ranges {
    private static final int MOD = 1_000_000_007;

    public long subArrayRanges(int[] nums) {
        return (calculateSumOfMax(nums) - calculateSumOfMin(nums) + MOD) % MOD;
    }
    
    private long calculateSumOfMax(int[] nums) {
        int n = nums.length;
        long totalMaxSum = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int idx = stack.pop();
                int prevIndex = stack.isEmpty() ? -1 : stack.peek();
                long leftCount = i - idx;
                long rightCount = idx - prevIndex;
                totalMaxSum = (totalMaxSum + nums[idx] * leftCount * rightCount) % MOD;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int prevIndex = stack.isEmpty() ? -1 : stack.peek();
            long leftCount = n - idx;
            long rightCount = idx - prevIndex;
            totalMaxSum = (totalMaxSum + nums[idx] * leftCount * rightCount) % MOD;
        }
        
        return totalMaxSum;
    }
    
    private long calculateSumOfMin(int[] nums) {
        int n = nums.length;
        long totalMinSum = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int idx = stack.pop();
                int prevIndex = stack.isEmpty() ? -1 : stack.peek();
                long leftCount = i - idx;
                long rightCount = idx - prevIndex;
                totalMinSum = (totalMinSum + nums[idx] * leftCount * rightCount) % MOD;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int prevIndex = stack.isEmpty() ? -1 : stack.peek();
            long leftCount = n - idx;
            long rightCount = idx - prevIndex;
            totalMinSum = (totalMinSum + nums[idx] * leftCount * rightCount) % MOD;
        }
        
        return totalMinSum;
    }

    public static void main(String[] args) {
        a32_leetcode_2104_sum_of_subarray_ranges solution = new a32_leetcode_2104_sum_of_subarray_ranges();
        
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 3, 3};
        int[] nums3 = {4, -2, -3, 4, 1};
        
        System.out.println(solution.subArrayRanges(nums1)); // Output: 4
        System.out.println(solution.subArrayRanges(nums2)); // Output: 4
        System.out.println(solution.subArrayRanges(nums3)); // Output: 59
    }
}
