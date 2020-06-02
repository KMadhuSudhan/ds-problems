package ds.problems.array;
//https://leetcode.com/problems/valid-triangle-number/
//611. Valid Triangle Number

import java.util.Arrays;

public class _611ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        if(nums.length<3)
            return 0;
        Arrays.sort(nums);
        int length = nums.length;
        int count = 0;
        for(int i=2;i<length;i++) {
            int left = 0;
            int right = i-1;
            while(left<right) {
                if((nums[left] + nums[right]) <= nums[i]){
                    left++;
                } else {
                    count += right - left;
                    right--;
                }
            }
        }
        return count;
    }
}
