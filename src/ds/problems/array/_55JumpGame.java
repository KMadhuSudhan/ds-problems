package ds.problems.array;
//https://leetcode.com/problems/jump-game/
//55. Jump Game

public class _55JumpGame {

    public boolean canJump(int[] nums) {
        int maxJump = nums[0];
        for (int i=0;i<nums.length-1;i++) {
            if(maxJump >= nums.length - i || maxJump>= nums.length -1) return true;
            if(nums[i] == 0 && maxJump < 1) return false;
            if(maxJump -1 >= nums[i+1]) {
                maxJump = maxJump - 1;
            } else {
                maxJump = nums[i+1];
            }
        }
        return true;
    }
}
