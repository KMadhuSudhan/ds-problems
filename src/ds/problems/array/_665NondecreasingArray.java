package ds.problems.array;
//https://leetcode.com/problems/non-decreasing-array/
//665. Non-decreasing Array

public class _665NondecreasingArray {

    public boolean checkPossibility(int[] nums) {
        if(nums.length < 2) return true;
        int count = 0;
        if(nums[0] > nums[1]) {
            count++;
        }
        for(int i=1;i<nums.length-1;i++) {
            if(nums[i] > nums[i+1]) {
                if(nums[i-1] < nums[i+1]) {
                    nums[i] = nums[i-1];
                } else {
                    nums[i+1] = nums[i];
                }
                count++;
                if(count > 1) return false;
            }
        }
        return true;
    }
}
