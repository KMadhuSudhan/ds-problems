package ds.problems.array;
//https://leetcode.com/problems/shuffle-the-array/
//1470. Shuffle the Array

public class _1470ShuffletheArray {

    public int[] shuffle(int[] nums, int n) {
        int j=0,i=n,k=0;
        int[] ans = new int[nums.length];
        while(i<nums.length) {
            ans[k++] = nums[j++];
            ans[k++] = nums[i++];
        }
        return ans;
    }
}
