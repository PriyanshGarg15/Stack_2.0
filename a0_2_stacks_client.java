public class a0_2_stacks_client {
    public static void main(String[] args) throws Exception {
        a0_1_stacks_implementation.Stack s = new a0_1_stacks_implementation.Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.display();
        System.out.println("Top element is: " + s.pop());
        s.display();
        System.out.println("Stack size is: " + s.size());
    }
}
