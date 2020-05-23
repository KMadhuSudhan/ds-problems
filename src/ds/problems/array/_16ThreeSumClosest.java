package ds.problems.array;

import java.util.Arrays;
//https://leetcode.com/problems/3sum-closest/
//
public class _16ThreeSumClosest {
    public static void main(String[] args) {
        _16ThreeSumClosest threeSumClosest = new _16ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        threeSumClosest.threeSumClosest(nums,1);
    }
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        if(length == 3) return nums[0] + nums[1] + nums[2];
        for(int i=0;i<length-2;i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i+1;
            int right = length-1;
            while(left < right) {
                int current =  nums[i] + nums[left] + nums[right];
                if(current == target) return target;
                if(Math.abs(current - target) < Math.abs(result - target)) {
                    result =  current;
                }
                if(current < target) {
                    left++;
                } else {
                    right --;
                }
                while(left < right && nums[left] == nums[left-1])
                    left++;

                while(left < right && right < nums.length - 1 && nums[right] == nums[right+1])
                    right--;
            }
        }
        return result;
    }
}
