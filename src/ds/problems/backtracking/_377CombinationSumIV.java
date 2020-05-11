package ds.problems.backtracking;
//https://leetcode.com/problems/combination-sum-iv/
//377. Combination Sum IV

public class _377CombinationSumIV {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        _377CombinationSumIV combinationSumIV = new _377CombinationSumIV();
        System.out.println(combinationSumIV.combinationSum4(nums, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
