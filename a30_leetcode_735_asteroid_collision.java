import java.util.Stack;
import java.util.Arrays;

public class a30_leetcode_735_asteroid_collision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (stack.peek() < -asteroid) {
                        stack.pop();
                    } else if (stack.peek() == -asteroid) {
                        stack.pop();
                        asteroid = 0;
                        break;
                    } else {
                        asteroid = 0;
                        break;
                    }
                }
                if (asteroid != 0) {
                    stack.push(asteroid);
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        a30_leetcode_735_asteroid_collision solution = new a30_leetcode_735_asteroid_collision();
        
        int[] asteroids1 = {5, 10, -5};
        int[] asteroids2 = {8, -8};
        int[] asteroids3 = {10, 2, -5};

        System.out.println(Arrays.toString(solution.asteroidCollision(asteroids1))); // Output: [5, 10]
        System.out.println(Arrays.toString(solution.asteroidCollision(asteroids2))); // Output: []
        System.out.println(Arrays.toString(solution.asteroidCollision(asteroids3))); // Output: [10]
    }
}
