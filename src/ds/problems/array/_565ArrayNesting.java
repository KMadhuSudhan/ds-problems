package ds.problems.array;
//https://leetcode.com/problems/array-nesting/
//565. Array Nesting

import java.util.HashSet;
import java.util.Set;

public class _565ArrayNesting {

    public int arrayNesting(int[] nums) {
        Set<Integer> set = new HashSet();
        int i=0,maxLen = 0;
        while(i<nums.length) {
            if(!set.contains(nums[i])) {
                int size = 0;
                int n = nums[i];
                while(!set.contains(n)) {
                    set.add(n);
                    n = nums[n];
                    size++;
                }
                maxLen = Math.max(maxLen,size);
            }
            i++;
        }
        return maxLen;
    }
}
