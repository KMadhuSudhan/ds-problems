package ds.problems.matrix;
//https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
//668. Kth Smallest Number in Multiplication Table

public class _668KthSmallestNumberInMultiplicationTable {

    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(check(mid, m, n, k)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    boolean check(int val, int m, int n, int k) {
        int cnt = 0;
        for(int i = 1; i <= m; i++) {
            if(i >  val) {
                break;
            }
            cnt += Math.min(n, val / i);
        }
        return cnt >= k;
    }
}
