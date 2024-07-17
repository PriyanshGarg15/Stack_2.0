import java.util.Stack;

public class a8_leetcode_85_maximal_rectangle {

    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };

        int maxArea = maximalRectangle(matrix);
        System.out.println("Maximal Rectangle Area: " + maxArea); // Expected output: 6
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxArea = 0;
        int[] heights = new int[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            // Update heights array based on current row
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    heights[col]++;
                } else {
                    heights[col] = 0;
                }
            }

            // Calculate maximal rectangle area for current row as histogram
            int rowMaxArea = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, rowMaxArea);
        }

        return maxArea;
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
