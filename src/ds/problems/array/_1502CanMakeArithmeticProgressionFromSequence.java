package ds.problems.array;
//https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
//1502. Can Make Arithmetic Progression From Sequence

import java.util.HashSet;
import java.util.Set;

public class _1502CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        Set<Integer> set = new HashSet();
        for(int num: arr) {
            min = Math.min(min,num);
            max = Math.max(max,num);
            set.add(num);
        }
        int d = max - min;
        if(d%(n-1)!=0) return false;
        d/=n-1;
        int i =0;
        while(i<n) {
            if(!set.contains(min)) return false;
            min+=d;
            i++;
        }
        return true;
    }
}
