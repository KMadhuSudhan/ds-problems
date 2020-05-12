package ds.problems.slidingwindow;
//https://leetcode.com/problems/minimum-size-subarray-sum/
//209. Minimum Size Subarray Sum

public class _209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        _209MinimumSizeSubarraySum minimumSizeSubarraySum = new _209MinimumSizeSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        minimumSizeSubarraySum.minSubArrayLen(7,nums);
    }
    public int minSubArrayLen(int s, int[] nums) {
        int low = 0,high = 0,minLen = Integer.MAX_VALUE,sum=0;
        while(high < nums.length) {
            sum+=nums[high];
            while(sum>=s) {
                minLen = Math.min(minLen,high+1-low);
                sum-=nums[low++];
            }
            high++;
        }
        return minLen!=Integer.MAX_VALUE ? minLen : 0;
    }
}
