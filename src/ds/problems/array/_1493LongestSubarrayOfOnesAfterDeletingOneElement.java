package ds.problems.array;
//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
//1493. Longest Subarray of 1's After Deleting One Element

import java.util.ArrayList;
import java.util.List;

public class _1493LongestSubarrayOfOnesAfterDeletingOneElement {
    public static void main(String[] args) {
        _1493LongestSubarrayOfOnesAfterDeletingOneElement longestSubarrayOfOnesAfterDeletingOneElement = new _1493LongestSubarrayOfOnesAfterDeletingOneElement();
        int[] nums = {1,1,0,1};
        longestSubarrayOfOnesAfterDeletingOneElement.longestSubarray(nums);
    }

    public int longestSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int part1 = 0,part2 = 0,ans = 0,i=0,ones =0;
        while(i<nums.length) {
            if(nums[i] == 1) {
                ones++;
            } else {
                if(part1 == 0) {
                    part1 = ones;
                } else {
                    part1 = part2;
                    part2 = ones;
                }
                Math.max(ans,part1+part2);
                ones = 0;
            }
            i++;
        }
       return ans;
    }

    public int longestSubarrayArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i=0,ones = 0;
        while(i<nums.length) {
            if(nums[i] == 1) {
                ones++;
            } else {
                list.add(ones);
                ones = 0;
            }
            i++;
        }
        if(list.size() == 0) return nums.length-1;
        if(nums[nums.length-1] == 1) list.add(ones);
        int ans = 0,size = list.size();
        i = 0;
        while(i<=size-2) {
            ans = Math.max(ans,list.get(i) + list.get(i+1));
            i++;
        }
        return ans;
    }
}
