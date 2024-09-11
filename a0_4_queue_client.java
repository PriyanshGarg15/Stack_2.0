import java.util.Queue;

public class a4_queue_client 
{
    public static void main(String[] args) 
    {
        a3_queue_implementation.Queue q = new a3_queue_implementation.Queue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.display(); // Output: 10 20 30 40 50

        System.out.println("Dequeued: " + q.dequeue()); // Output: Dequeued: 10
        q.display(); // Output: 20 30 40 50

        q.enqueue(60);
        q.display(); // Output: 20 30 40 50 60

        System.out.println("Front: " + q.getfront()); // Output: Front: 20
    }
}
