package ds.problems.array;
//https://leetcode.com/problems/matchsticks-to-square/
//473. Matchsticks to Square

public class _473MatchsticksToSquare {

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) return false;
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, visited, sum / 4, 0, 0, 4);
    }

    private boolean dfs(int[] nums, boolean[] visited, int target, int sum, int idx, int round) {
        if (round == 0) return true;
        if (sum == target && dfs(nums, visited, target, 0, 0, round - 1)) return true;
        for (int i = idx; i < nums.length; i++) {
            if (!visited[i] && sum + nums[i] <= target) {
                visited[i] = true;
                if (dfs(nums, visited, target, sum + nums[i], i + 1, round))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
