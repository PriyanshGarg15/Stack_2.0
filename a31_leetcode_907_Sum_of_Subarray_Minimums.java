import java.util.Stack;

public class a31_leetcode_907_Sum_of_Subarray_Minimums {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;
        long result = 0;
        
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        for (int i = 0; i < n; i++) {
            long left = i - prevSmaller[i];
            long right = nextSmaller[i] - i;
            result = (result + arr[i] * left * right) % MOD;
        }
        
        return (int) result;
    }

    public static void main(String[] args) {
        a31_leetcode_907_Sum_of_Subarray_Minimums solution = new a31_leetcode_907_Sum_of_Subarray_Minimums();
        
        int[] arr1 = {3, 1, 2, 4};
        int[] arr2 = {11, 81, 94, 43, 3};
        
        System.out.println(solution.sumSubarrayMins(arr1));
        System.out.println(solution.sumSubarrayMins(arr2));
    }
}
