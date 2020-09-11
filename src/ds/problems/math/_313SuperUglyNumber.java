package ds.problems.math;
//https://leetcode.com/problems/super-ugly-number
//313. Super Ugly Number
public class _313SuperUglyNumber {
    public static void main(String[] args) {
        _313SuperUglyNumber superUglyNumber = new _313SuperUglyNumber();
        int[] primes = {3,5,7,11,19,23,29,41,43,47};
        int n=15;
        System.out.println(superUglyNumber.nthSuperUglyNumber(n,primes));
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length, cur;
        int[] idx = new int[m];
        int[] res = new int[n];
        res[0] = 1;
        for (int i=1; i<n; i++){
            cur = Integer.MAX_VALUE;
            for (int j=0; j<m; j++){
                cur = Math.min(cur, primes[j]*res[idx[j]]);
            }
            for (int j=0; j<m; j++){
                idx[j] = primes[j]*res[idx[j]]<=cur? idx[j]+1: idx[j];
            }
            res[i] = cur;
        }
        return res[n-1];
    }
}
