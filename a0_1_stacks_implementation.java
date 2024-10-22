//we will use array for implementation
//and will put restrictions on it so that
//index access will be made not possible


//push 
//pop
//peek
//displaly
//size
//isempty
//isfull

public class a0_1_stacks_implementation 
{

    public static class Stack 
    {
        private int[] arr;
        private int idx = -1;

        public Stack() {
            arr = new int[5];
        }

        public Stack(int n) {
            arr = new int[n];
        }

        // O(1)
        public boolean isempty() {
            return idx == -1;
        }

        // O(1)
        public void push(int item) throws Exception {
            if (isfull()) {
                throw new Exception("Stack is full");
            }
            idx++;
            arr[idx] = item;
        }

        // O(1)
        public int size() {
            return idx + 1;
        }

        // O(1)
        public boolean isfull() {
            return idx == arr.length - 1;
        }

        // O(1)
        public int pop() throws Exception {
            if (isempty()) {
                throw new Exception("Stack is empty");
            }
            int pg=arr[idx];
            idx--;
            return pg;
        }

        public void display() {
            for (int i = 0; i <= idx; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        // O(1)
        public int peek() throws Exception {
            if (isempty()) {
                throw new Exception("Stack is empty");
            }
            return arr[idx];
        }
    }
}
