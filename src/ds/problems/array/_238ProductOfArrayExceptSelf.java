package ds.problems.array;
//https://leetcode.com/problems/product-of-array-except-self/
//238. Product of Array Except Self

public class _238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,0};
        _238ProductOfArrayExceptSelf productOfArrayExceptSelf = new _238ProductOfArrayExceptSelf();
        productOfArrayExceptSelf.productExceptSelf(nums);
    }
    public int[] productExceptSelf(int[] nums) {
        int zeros = 0,zeroIndex = -1;
        int product = 1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0) {
                zeros++;
                zeroIndex = i;
            } else {
                product*=nums[i];
            }
        }
        int[] ans = new int[nums.length];
        if(zeros > 1) return ans;
        if(zeros == 1) {
            ans[zeroIndex] = product;
            return ans;
        }
        for(int i=0;i<nums.length;i++) {
            ans[i] =  product/nums[i];
        }
        return ans;
    }
/*
      with division
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        ans[0] = nums[0];
        for(int i=1;i<length;i++) {
            ans[i] = ans[i-1] * nums[i];
        }
        int rightProduct = nums[length-1];
        for (int i= length-2;i>0;i--) {
            ans[i] = rightProduct * ans[i-1];
            rightProduct = rightProduct * nums[i];
        }
        ans[0] = rightProduct;
        return ans;
    }
    */
}
