package ds.problems.string;
//https://leetcode.com/problems/make-the-string-great/
//1544. Make The String Great
public class _1544MakeTheStringGreat {
    public String makeGood(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        for (int j = 0; j < arr.length; j++, i++) {
            arr[i] = arr[j]; //
            if (i > 0 && Math.abs(arr[i] - arr[i - 1]) == 32) {
                i -= 2; // after each iteration, i++, so here i -= 2
            }
        }

        return new String(arr, 0, i);
    }
}
