package ds.problems.array;
//https://leetcode.com/problems/house-robber/
//198. House Robber

public class _198HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int value1 = nums[0];
        int value2 = Math.max(nums[0], nums[1]);
        int max = 0;
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(value1 + nums[i], value2);
            value1 = value2;
            value2 = max;
        }
        return max;
    }
}
