package ds.problems.array;
//https://leetcode.com/problems/intersection-of-two-arrays/
//349. Intersection of Two Arrays

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        _349IntersectionOfTwoArrays intersectionOfTwoArrays = new _349IntersectionOfTwoArrays();
        intersectionOfTwoArrays.intersection(num1,num2);
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        for(int i=0;i<nums1.length;i++) {
            set.add(nums1[i]);
        }
        List<Integer> intersection = new ArrayList<>();
        for(int j=0;j<nums2.length;j++) {
            if(set.contains(nums2[j])) {
                intersection.add(nums2[j]);
            }
        }
        int output[] = new int[intersection.size()];
        int i=0;
        for(int num: intersection) {
            output[i++] = num;
        }
        return output;
    }
}
