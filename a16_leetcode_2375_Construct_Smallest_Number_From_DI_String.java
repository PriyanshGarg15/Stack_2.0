import java.util.Scanner;
import java.util.Stack;

public class a16_leetcode_2375_Construct_Smallest_Number_From_DI_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); //"IIIDIDDD"
        String ans = smallestNumber(str);
        System.out.println(ans);
    }
    public static String smallestNumber(String pattern) {
        int n = pattern.length();
		int[] ans = new int[n + 1];
		Stack<Integer> st = new Stack<>();
		int c = 1;
        for (int i = 0; i <= n; i++) {
			if (i == n || pattern.charAt(i) == 'I') {
				ans[i] = c;
				c++;
				while (!st.isEmpty()) {
					ans[st.pop()] = c;
					c++;

				}

			} else {
				st.push(i);
			}
		}
        String str = "";
		for (int i = 0; i < ans.length; i++) {
			str += ans[i];
		}
		return str;
    }
}
