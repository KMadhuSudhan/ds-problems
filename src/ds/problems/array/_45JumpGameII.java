package ds.problems.array;
//https://leetcode.com/problems/jump-game-ii/
//45. Jump Game II

public class _45JumpGameII {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int i = 0;
        while (i + nums[i] < nums.length - 1) {
            int maxVal = 0;
            int maxValIndex = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (nums[j + i] + j > maxVal) {
                    maxVal = nums[j + i] + j;
                    maxValIndex = i + j;
                }
            }
            i = maxValIndex;
            count++;
        }
        return count + 1;
    }
}
