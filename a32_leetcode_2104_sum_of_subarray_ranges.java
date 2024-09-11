import java.util.Stack;

public class a32_leetcode_2104_sum_of_subarray_ranges {

    public long subArrayRanges(int[] arr) {
        long sumOfMax = calculateSumOfMax(arr);
        long sumOfMin = calculateSumOfMin(arr);
        return sumOfMax - sumOfMin;
    }

    public long calculateSumOfMax(int[] arr) {
        int n = arr.length;
        long result = 0;
        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            prevGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - prevGreater[i];
            long right = nextGreater[i] - i;
            result += (long) arr[i] * left * right;
        }

        return result;
    }

    public long calculateSumOfMin(int[] arr) {
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
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - prevSmaller[i];
            long right = nextSmaller[i] - i;
            result += (long) arr[i] * left * right;
        }

        return result;
    }

    public static void main(String[] args) {
        a32_leetcode_2104_sum_of_subarray_ranges solution = new a32_leetcode_2104_sum_of_subarray_ranges();

        // Test case 1
        int[] arr1 = {1, 2, 3};
        System.out.println("Sum of subarray ranges for [1, 2, 3]: " + solution.subArrayRanges(arr1));

        // Test case 2
        int[] arr2 = {1, 3, 3};
        System.out.println("Sum of subarray ranges for [1, 3, 3]: " + solution.subArrayRanges(arr2));

        // Test case 3
        int[] arr3 = {4, -2, -3, 4, 1};
        System.out.println("Sum of subarray ranges for [4, -2, -3, 4, 1]: " + solution.subArrayRanges(arr3));
    }
}
