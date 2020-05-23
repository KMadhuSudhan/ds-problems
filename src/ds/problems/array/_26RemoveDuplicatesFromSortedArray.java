package ds.problems.array;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//26. Remove Duplicates from Sorted Array

public class _26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        _26RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new _26RemoveDuplicatesFromSortedArray();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i=1; i < nums.length; i++) {
            if(nums[i]!=nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
//    public int removeDuplicates(int[] nums) {
//        int max = nums[nums.length-1],i=0;
//        for(;i<nums.length;i++) {
//            int num=nums[i],j=i;
//            while(j < nums.length && num == nums[j]) {
//                j++;
//            }
//            if(j-i > 1) {
//                int k=i+1;
//                while(j<nums.length) {
//                    nums[k++] = nums[j];
//                    j++;
//                }
//            }
//            if(num==max) break;
//        }
//        return i+1;
//    }
}
