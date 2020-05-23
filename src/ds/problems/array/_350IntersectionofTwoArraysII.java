package ds.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _350IntersectionofTwoArraysII {
    public static void main(String[] args) {
        _350IntersectionofTwoArraysII intersectionofTwoArraysII = new _350IntersectionofTwoArraysII();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(intersectionofTwoArraysII.intersect(nums1,nums2));
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> l=new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]==nums2[j])
            {
                l.add(nums1[i]);
                i++;j++;
            }
            else if(nums1[i]<nums2[j])
                i++;
            else
                j++;
        }
        int[] ans = new int[l.size()];
        int count = 0;
        for(int x:l) {
            ans[count++] = x;
        }
        return ans;
    }
    boolean binarySearch(int[] nums,int target) {
        int low = 0,high = nums.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }
}
