package ds.problems.array;
//https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
//1296. Divide Array in Sets of K Consecutive Numbers

import java.util.HashSet;
import java.util.Set;

public class _1296DivideArrayInSetsOfKConsecutiveNumbers {

    public boolean isPossibleDivide(int[] nums, int k) {
        int[] map = new int[k];
        Set<Integer> set = new HashSet();
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++) {
            int key = nums[i] % k;
            if(set.contains(nums[i] -1) || set.contains(nums[i] +1)) {
                map[key]+=1;
            } else {
                return false;
            }
        }
        int val = map[0];
        for(int key: map) {
            if(val!=key) return false;
        }
        return true;
    }
}
