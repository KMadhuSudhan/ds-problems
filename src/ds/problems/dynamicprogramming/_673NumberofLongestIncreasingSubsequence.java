package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/number-of-longest-increasing-subsequence/
//673. Number of Longest Increasing Subsequence

public class _673NumberofLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        if(nums.length<=1) return nums.length;
        int dp[]= new int[nums.length];
        int cnt[] = new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=1;
            cnt[i]=1;
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    if(dp[j] + 1 >dp[i]){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                    else if(dp[j] + 1 ==dp[i])
                        cnt[i] += cnt[j];
                }

            }
            if(max<dp[i])
                max=dp[i];
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(max==dp[i])
                count=count+cnt[i];
        }
        return count;
    }
}
