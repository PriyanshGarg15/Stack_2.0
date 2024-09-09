import java.util.*;

public class a11_leetcode_739_daily_temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            ans[i] = s.isEmpty() ? 0 : s.peek() - i;
            s.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        a11_leetcode_739_daily_temperatures solution = new a11_leetcode_739_daily_temperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result)); // Expected output: [1, 1, 4, 2, 1, 1, 0, 0]
    }
}
