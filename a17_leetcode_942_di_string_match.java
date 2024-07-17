public class a17_leetcode_942_di_string_match {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];
        int left = 0, right = n;

        for (int i = 0; i <= n; i++) {
            if (i == n || s.charAt(i) == 'I') {
                perm[i] = left++;
            } else {
                perm[i] = right--;
            }
        }

        return perm;
    }
}
