import java.util.Stack;

public class a31_907_Sum_of_Subarray_Minimums {

    public long subArrayRanges(int[] arr) {
        // Calculate the sum of subarray max elements minus the sum of subarray min elements
        long sumOfMax = calculateSumOfMax(arr);
        long sumOfMin = calculateSumOfMin(arr);
        return sumOfMax - sumOfMin;
    }

    private long calculateSumOfMax(int[] arr) {
        int n = arr.length;
        long result = 0;
        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Calculate previous greater for each element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            prevGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Calculate next greater for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Sum up contributions when current element is the max in its subarrays
        for (int i = 0; i < n; i++) {
            long left = i - prevGreater[i];
            long right = nextGreater[i] - i;
            result += (long) arr[i] * left * right;
        }

        return result;
    }

    private long calculateSumOfMin(int[] arr) {
        int n = arr.length;
        long result = 0;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Calculate previous smaller for each element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Calculate next smaller for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Sum up contributions when current element is the min in its subarrays
        for (int i = 0; i < n; i++) {
            long left = i - prevSmaller[i];
            long right = nextSmaller[i] - i;
            result += (long) arr[i] * left * right;
        }

        return result;
    }

    public static void main(String[] args) {
        a31_907_Sum_of_Subarray_Minimums solution = new a31_907_Sum_of_Subarray_Minimums();

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, -2, -3, 4, 1};

        System.out.println(solution.subArrayRanges(arr1)); // Output: 4
        System.out.println(solution.subArrayRanges(arr2)); // Output: 59
    }
}
