package ds.problems.array;
//https://leetcode.com/problems/single-element-in-a-sorted-array/
//540. Single Element in a Sorted Array

public class _540SingleElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        _540SingleElementInSortedArray singleElementInSortedArray = new _540SingleElementInSortedArray();
        singleElementInSortedArray.singleNonDuplicate(nums);
    }
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            ans^=nums[i];
        }
        return ans;
    }
}
