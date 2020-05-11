package ds.problems.binarysearch;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
//33. Search in Rotated Sorted Array

public class _33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        _33SearchInRotatedSortedArray searchInRotatedSortedArray = new _33SearchInRotatedSortedArray();
        searchInRotatedSortedArray.search(nums,0);
    }
    public int search(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }

    public int search(int[] nums, int l, int h, int key) {
        if(l>h) return -1;
        int mid = (l+h)/2;
        if(nums[mid] == key) {
            return mid;
        }
        if(nums[l]<=nums[mid]) {
            if(key >= nums[l] && key <= nums[mid]) {
                return search(nums,l,mid-1,key);
            } else {
                return search(nums,mid+1,h,key);
            }
        }

        if(key >= nums[mid] && key <= nums[h]) {
            return search(nums,mid+1,h,key);
        }
        return search(nums,l,mid-1,key);
    }
}
