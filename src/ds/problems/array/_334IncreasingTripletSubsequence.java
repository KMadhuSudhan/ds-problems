package ds.problems.array;
//https://leetcode.com/problems/increasing-triplet-subsequence/
//334. Increasing Triplet Subsequence

public class _334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;
        int firstMax = Integer.MIN_VALUE,secondMax = Integer.MIN_VALUE,thirdMax = Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--) {
            if(nums[i] > firstMax) {
                firstMax = nums[i];
            } else if(nums[i] > secondMax && nums[i] < firstMax) {
                secondMax = nums[i];
            } else if(nums[i] > thirdMax && nums[i] < secondMax) {
                thirdMax = nums[i];
            }
        }
        return firstMax!=Integer.MIN_VALUE && secondMax!=Integer.MIN_VALUE && thirdMax!=Integer.MIN_VALUE;
    }
}
/*1,2,17,15,12,3,-8 -7

15,
 */