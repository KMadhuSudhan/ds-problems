package ds.problems.array;
//https://leetcode.com/problems/house-robber-ii/
//213. House Robber II

import java.util.Arrays;

public class _213HouseRobberII {

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[3];
        for(int i = nums.length-1; i > 0; i--){
            dp[0] = Math.max(nums[i] + dp[2], dp[1]);
            dp[2] = dp[1];
            dp[1] = dp[0];
        }
        int temp = dp[0];
        Arrays.fill(dp, 0);
        for(int i = 0; i< nums.length-1; i++){
            dp[0] = Math.max(nums[i] + dp[2], dp[1]);
            dp[2] = dp[1];
            dp[1] = dp[0];
        }
        return Math.max(dp[0], temp);
    }
}
