public class a3_queue_implementation 
{
    public static class Queue
    {
        private int[] arr;
        private int front = 0;
        private int rear = 0;
        private int size = 0;

        public Queue() {
            arr = new int[5];
        }

        public Queue(int n) {
            arr = new int[n];
        }

        public boolean isempty() 
        {
            return size == 0;
        }

        public boolean isfull() 
        {
            return size == arr.length;
        }

        public void enqueue(int item) 
        {
            if (isfull()) {
                System.out.println("Queue is full");
                return;
            }
            arr[rear] = item;
            rear++;
            size++;
        }

        public int size() 
        {
            return size;
        }

        public int dequeue() {
            if (isempty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int pg = arr[front];
            for (int i = front; i < rear - 1; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            size--;
            return pg;
        }

        public void display() {
            if (isempty()) {
                System.out.println("Queue is empty");
                return;
            }
            for (int i = front; i < rear; i++) 
            {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        public int getfront() {
            if (isempty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }
}