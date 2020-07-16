package ds.problems.array;
//https://leetcode.com/problems/partition-equal-subset-sum/
//416. Partition Equal Subset Sum

public class _416PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum+=num;
        }
        if(sum%2 == 1) return false;
        return canPartition(nums,sum/2);
    }

    //double array
//
//    boolean canPartition(int[] nums,int target) {
//        boolean[][] dp = new boolean[nums.length+1][target+1];
//        for(int i=0;i<nums.length;i++) {
//            dp[i][0] = true;
//        }
//        for(int i=1;i<=nums.length;i++) {
//            for(int j=1;j<=target;j++) {
//                dp[i][j] = dp[i-1][j];
//                if(j>=nums[i-1]) {
//                    dp[i][j] = (dp[i-1][j] || dp[i-1][j-nums[i-1]]);
//                }
//            }
//        }
//        return dp[nums.length][target];
//    }

    //single array

    boolean canPartition(int[] nums,int target) {
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int num: nums) {
            for(int j=num;j<=target;j++) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

}
