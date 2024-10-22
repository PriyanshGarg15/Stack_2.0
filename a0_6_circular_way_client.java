public class a0_6_circular_way_client {
    public static void main(String[] args) {
        a0_5_circular_way.Queue q = new a0_5_circular_way.Queue(5);

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
