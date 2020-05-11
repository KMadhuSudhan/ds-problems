package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/longest-turbulent-subarray/
//978. Longest Turbulent Subarray

public class _978LongestTurbulentSubarray {

    public static void main(String[] args) {
        int[] nums = {4,8,12,16};
        _978LongestTurbulentSubarray longestTurbulentSubarray = new _978LongestTurbulentSubarray();
        System.out.println(longestTurbulentSubarray.maxTurbulenceSize(nums));
    }

    public int maxTurbulenceSize(int[] A) {
        if(A.length<2) return A.length;
        int length = 0,maxLen = 0;
        for (int i=1;i<A.length-1;i++) {

        }
        return maxLen;
    }
}
