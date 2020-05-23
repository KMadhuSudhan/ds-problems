package ds.problems.array;
//https://leetcode.com/problems/target-sum
//494. Target Sum
public class _494TargetSum {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums,0,S);
        return ans;
    }
    void dfs(int[] nums,int index,int sum) {
        if(index == nums.length) {
            if(sum == 0) {
                ans++;
            }
            return ;
        }
        dfs(nums,index+1,sum-nums[index]);
        dfs(nums,index+1,sum+nums[index]);
    }
}
