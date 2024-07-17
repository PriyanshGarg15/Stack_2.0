import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class a19_leetcode_739_daily_temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = s.peek() - i;
            }
            s.push(i); // push the current index onto the stack
        }

        return ans;
    }

    public static void main(String[] args) {
        a19_leetcode_739_daily_temperatures solution = new a19_leetcode_739_daily_temperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);
        System.out.println(java.util.Arrays.toString(result)); // Expected output: [1, 1, 4, 2, 1, 1, 0, 0]
    }
}
