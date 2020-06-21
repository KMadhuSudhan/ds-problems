package ds.problems.system.design;
//https://leetcode.com/problems/random-pick-index/
//398. Random Pick Index

import java.util.*;

public class _398RandomPickIndex {
    Map<Integer, List<Integer>> targets = new HashMap<>();
    Random r = new Random();
    public _398RandomPickIndex(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            targets.computeIfAbsent(nums[i], k -> new ArrayList()).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = targets.get(target);
        return list.get(r.nextInt(list.size()));
    }
}
