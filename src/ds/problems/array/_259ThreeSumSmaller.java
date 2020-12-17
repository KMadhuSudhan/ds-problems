package ds.problems.array;

import java.util.Arrays;

public class _259ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            int left = i+1;
            int right = nums.length-1;
            while(left<right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    count+= right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
