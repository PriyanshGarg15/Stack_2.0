import java.util.Stack;

public class a7_leetcode_84_largest_reactangle_in_histogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int max = largestRectangleArea(heights);
        System.out.println(max); // Expected output: 10
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] nextsmallest_right = new int[heights.length];
        int[] nextsmallest_left = new int[heights.length];

        // Next smaller on right
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextsmallest_right[i] = heights.length;
            } else {
                nextsmallest_right[i] = st.peek();
            }
            st.push(i);
        }

        // Clear stack for the next iteration
        st.clear();

        // Next smaller on left
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextsmallest_left[i] = -1;
            } else {
                nextsmallest_left[i] = st.peek();
            }
            st.push(i);
        }

        // Calculate maximum area
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = nextsmallest_right[i] - nextsmallest_left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
