package ds.problems.array;
//https://leetcode.com/problems/subarray-product-less-than-k/
//713. Subarray Product Less Than K

public class _713SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int i=0,j=0,product=1,count=0;
        while(i<nums.length) {
            product*=nums[i];
            while(product>=k) {
                product/=nums[j];
                j++;
            }
            count += i - j  +1;
            i++;
        }
        return count;
    }
}
