package ds.problems.array;
//https://leetcode.com/problems/running-sum-of-1d-array/
//5453. Running Sum of 1d Array

public class _5453RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            ans[i] = nums[i] + ans[i-1];
        }
        return ans;
    }
}
