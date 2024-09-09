import java.util.Stack;

public class a9_leetcode_85_maximal_rectangle {

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
                heights[col] = matrix[row][col] == '1' ? heights[col] + 1 : 0;
            }

            // Calculate maximal rectangle area for current row as histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] nextSmallestRight = new int[heights.length];
        int[] nextSmallestLeft = new int[heights.length];

        // Next smaller on right
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nextSmallestRight[i] = st.isEmpty() ? heights.length : st.peek();
            st.push(i);
        }

        // Clear stack for the next iteration
        st.clear();

        // Next smaller on left
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nextSmallestLeft[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // Calculate maximum area
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = nextSmallestRight[i] - nextSmallestLeft[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;
    }
}
