package ds.problems.array;
//https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
//1464. Maximum Product of Two Elements in an Array

public class _1464MaximumProductofTwoElements {

    public int maxProduct(int[] nums) {
        if(nums.length < 2) return 0;
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
            } else if(nums[i] > max2) {
                max2 = nums[i];
            }
        }
        max1--;
        max2--;
        return max1 * max2;
    }
}
