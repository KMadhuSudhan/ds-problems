package ds.problems.array;
//https://leetcode.com/problems/longest-continuous-increasing-subsequence/
//674. Longest Continuous Increasing Subsequence

public class _674LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int i =0,max=0;
        while(i<nums.length) {
            int j =i;
            while(i+1<nums.length && nums[i]<nums[i+1]) {
                i++;
            }
            i++;
            max = Math.max(max,i-j);
        }
        return max;
    }
}
