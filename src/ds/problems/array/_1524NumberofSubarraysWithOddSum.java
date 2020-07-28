package ds.problems.array;
//https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
//1524. Number of Sub-arrays With Odd Sum

public class _1524NumberofSubarraysWithOddSum {
    public int numOfSubarrays(int[] arr) {
        int odd = 0, even = 0, sum = 0;
        for (int n : arr) {
            if (n % 2 == 1) {
                int temp = odd;
                odd = even + 1;
                even = temp;
            }
            else
                ++even;
            sum = (sum + odd) % 1000000007;
        }
        return sum;
    }

    public int numOfSubarraysSimpified(int[] arr) {
        int sum = 0;
        for (int i = 0, odd = 0; i < arr.length; ++i) {
            if (arr[i] % 2 == 1)
                odd = (i - odd) + 1;
            sum = (sum + odd)  % 1000000007;
        }
        return sum;
    }
}
