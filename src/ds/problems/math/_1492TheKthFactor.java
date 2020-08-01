package ds.problems.math;
//https://leetcode.com/problems/the-kth-factor-of-n/
//1492. The kth Factor of n

public class _1492TheKthFactor {
    public int kthFactor(int n, int k) {

        for(int i=1;i<=n;i++) {
            if(n%i == 0) {
                k--;
            }
            if(k ==0) return i;
        }
        return -1;
    }
}
