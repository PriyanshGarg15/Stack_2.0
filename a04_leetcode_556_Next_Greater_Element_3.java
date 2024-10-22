import java.util.*;
public class a04_leetcode_556_Next_Greater_Element_3 {
    public int nextGreaterElement(int n) {
        List<Integer> nm=new ArrayList<>();
        String k=String.valueOf(n);
        //what does valueof do?
        // int n = 123;
        // String s = String.valueOf(n);  // "123"
        for(int i=0;i<k.length();i++)
        {
            nm.add(k.charAt(i)-'0');
        }
        int i=nm.size()-1;
        while(i>0 && nm.get(i) <= nm.get(i-1))
        {
            i--;
        }
        if(i==0)
            return -1;
        i--;
        int j=nm.size()-1;
        while(nm.get(j) <= nm.get(i))
        {
            j--;
        }
        swap(nm,i,j);
        task_to_reverse(nm,i+1);
        k="";
        for(int ii=0;ii<nm.size();ii++)
        {
            k+=nm.get(ii);
        }
        if(Long.parseLong(k)>Integer.MAX_VALUE)
            return -1;
        else
            return Integer.parseInt(k);
    }
    public void swap(List<Integer> nm, int i, int j) {
        int temp = nm.get(i);
        nm.set(i, nm.get(j));
        nm.set(j, temp);
    }

    public void task_to_reverse(List<Integer> nm, int i)
    {
        int k=nm.size()-1;
        for(int j=i;j<k;j++)
        {
            swap(nm,j,k);
            k--;
        }
    }
    public static void main(String[] args) {
        a04_leetcode_556_Next_Greater_Element_3 sol = new a04_leetcode_556_Next_Greater_Element_3();
        int n = 1234;  
        int result = sol.nextGreaterElement(n);
        System.out.println("Next greater element: " + result);
    }
}
       