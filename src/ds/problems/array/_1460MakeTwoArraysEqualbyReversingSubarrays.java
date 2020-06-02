package ds.problems.array;
//https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
//1460. Make Two Arrays Equal by Reversing Sub-arrays

import java.util.Arrays;

public class _1460MakeTwoArraysEqualbyReversingSubarrays {

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for(int i=0;i<target.length;i++) {
            if(target[i] == arr[i]) continue;
            return false;
        }
        return true;
    }
}
