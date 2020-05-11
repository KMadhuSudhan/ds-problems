package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/maximum-subarray/
//53. Maximum Subarray

public class _53MaximumSubarray {
    public static void main(String[] args) {
        _53MaximumSubarray maximumSubarray = new _53MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maximumSubarray.maxSubArray(nums);
    }
    public int maxSubArray(int[] nums) {
        int sum = 0,maxSumSoFar=0;
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            if(sum<0) {
                sum = 0;
            }
            if(maxSumSoFar < sum) {
                maxSumSoFar = sum;
            }
        }
        return maxSumSoFar;
    }
}
