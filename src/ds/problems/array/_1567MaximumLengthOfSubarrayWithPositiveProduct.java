package ds.problems.array;

public class _1567MaximumLengthOfSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int firstNegative = -1,firstZero = -1,negatvies=0,ans = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] < 0) {
                negatvies++;
                if(firstNegative == -1) firstNegative = i;
            }
            else if(nums[i] == 0) {
                negatvies = 0;
                firstNegative = -1;
                firstZero = i;
            }
            if(negatvies%2 == 0) {
                ans =  Math.max(i - firstZero,ans);
            } else {
                ans =  Math.max(i - firstNegative,ans);
            }
        }
        return ans;
    }
}
