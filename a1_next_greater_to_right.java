import java.util.Stack;
public class a1_next_greater_to_right {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 2, 4, 6, 11, 9, 6 };
		int[] ans=NGE(arr);
        for(int i=0;i<ans.length;i++)
        {
            System.out.print(ans[i]+" ");
        }
	}
	public static int[] NGE(int[] arr) 
    {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }

        return ans;
    }
}