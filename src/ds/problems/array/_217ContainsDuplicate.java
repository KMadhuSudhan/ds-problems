package ds.problems.array;
//https://leetcode.com/problems/contains-duplicate/
//217. Contains Duplicate

import java.util.HashSet;
import java.util.Set;

public class _217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}
