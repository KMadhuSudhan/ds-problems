package ds.problems.array;
//https://leetcode.com/problems/largest-number-at-least-twice-of-others/
//747. Largest Number At Least Twice of Others

public class _747LargestNumberAtLeastTwiceofOthers {

    public int dominantIndex(int[] nums) {
        if(nums.length ==1) return 0;
        int max=nums[0],index=0;
        for(int i=1;i<nums.length;i++) {
            if(max < nums[i]) {
                max = nums[i];
                index = i;
            }
            max = Math.max(max,nums[i]);
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i]*2 > max && max!=nums[i]) {
                return -1;
            }
        }
        return index;
    }
}
