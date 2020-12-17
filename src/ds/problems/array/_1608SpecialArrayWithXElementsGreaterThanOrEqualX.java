package ds.problems.array;

import java.util.Arrays;

public class _1608SpecialArrayWithXElementsGreaterThanOrEqualX {

    public int specialArray(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        if(n <= nums[0]) return n;
        for(int i = 1; i < nums.length; i++) {
            n = nums.length-i;
            if(n <= nums[i] && n>nums[i-1])
                return n;
        }
        return -1;
    }
}
