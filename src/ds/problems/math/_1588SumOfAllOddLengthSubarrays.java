package ds.problems.math;
//https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
//1588. Sum of All Odd Length Subarrays

public class _1588SumOfAllOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] A) {
        int res = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            res += ((i + 1) * (n - i) + 1) / 2 * A[i];
        }
        return res;
    }
}


