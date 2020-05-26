package ds.problems.array;
//https://leetcode.com/problems/longest-turbulent-subarray/
//978. Longest Turbulent Subarray

public class _978LongestTurbulentSubarray {
    public static void main(String[] args) {
        int[] nums = {4,8,12,16};
        _978LongestTurbulentSubarray longestTurbulentSubarray = new _978LongestTurbulentSubarray();
        System.out.println(longestTurbulentSubarray.maxTurbulenceSize(nums));
    }

    public int maxTurbulenceSize(int[] A) {
        if (A.length < 2) {
            return A.length;
        }
        int max = 1;
        int start = 0;
        int end;

        while (start < A.length - 1) {
            if (A[start] == A[start+1]) {
                start++;
                continue;
            }
            end = start+1;
            while (end+1 < A.length && isTurbulent(A, end)) {
                end++;
            }
            max = Math.max(max, end-start+1);
            start = end;
        }
        return max;
    }
    private boolean isTurbulent(int[] A, int k) {
        return (A[k] > A[k-1] && A[k] > A[k+1]) || (A[k] < A[k-1]) && (A[k] < A[k+1]);
    }
}
