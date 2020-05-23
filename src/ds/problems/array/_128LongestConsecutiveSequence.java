package ds.problems.array;
//https://leetcode.com/problems/longest-consecutive-sequence/
//128. Longest Consecutive Sequence

import java.util.HashSet;
import java.util.Set;

public class _128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        int i=0,max=0;
        for(int num: nums) {
            set.add(num);
        }
        Set<Integer> visited = new HashSet();
        while( i < nums.length) {
            int length =1;
            int num = nums[i];
            if(!set.contains(num-1)) {
                int seq = num+1;
                while(set.contains(seq)) {
                    length++;
                    seq = seq+1;
                }
            }
            max = Math.max(max,length);
            i++;
        }
        return max;
    }
}
