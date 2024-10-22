//here i will us einbuilt queueui n java you can use sir made also !!

import java.util.LinkedList;
import java.util.Queue;

public class a0_10_queue_reverse {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        System.out.println("Original queue: " + queue);
        reverse(queue);
        System.out.println("Reversed queue: " + queue);
    }

    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int front = queue.poll(); //or use queue.remove();
        reverse(queue);
        queue.add(front);
    }
}
