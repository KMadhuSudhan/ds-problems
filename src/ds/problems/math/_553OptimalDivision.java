package ds.problems.math;
//https://leetcode.com/problems/optimal-division/
//553. Optimal Division

public class _553OptimalDivision {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) return "" + nums[0];
        if (nums.length == 2) return nums[0] + "/" + nums[1];
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        sb.append("/(");


        for (int i = 1; i < nums.length - 1; i++) {
            sb.append(nums[i]);
            sb.append("/");
        }
        sb.append(nums[nums.length - 1]);
        sb.append(")");
        return sb.toString();
    }
}
