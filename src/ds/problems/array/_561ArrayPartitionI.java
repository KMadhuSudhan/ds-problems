package ds.problems.array;
//https://leetcode.com/problems/array-partition-i/
//561. Array Partition I

import java.util.Arrays;

public class _561ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0;i<nums.length;i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
