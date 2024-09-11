//extra space of queue
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class a9_using_queue {
    public static void reverse(Stack<Integer> stack) {
        Queue<Integer> queue = new LinkedList<>();
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Original stack: " + stack);
        reverse(stack);
        System.out.println("Reversed stack: " + stack);
    }
}
