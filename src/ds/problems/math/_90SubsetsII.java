package ds.problems.math;
//https://leetcode.com/problems/subsets-ii/
//90. Subsets II

import java.util.*;
//https://leetcode.com/problems/subsets-ii/
//90. Subsets II

public class _90SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        _90SubsetsII subsetsII = new _90SubsetsII();
        System.out.println(subsetsII.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> subsets = new HashSet<>();
        Arrays.sort(nums);
        subsets(nums, subsets,new ArrayList<>(),0);
        return new ArrayList<>(subsets);
    }

    void subsets(int[] nums,Set<List<Integer>> result,List<Integer> currentList,int start) {
        result.add(new ArrayList<>(currentList));
        for(int i=start;i<nums.length;i++) {
            currentList.add(nums[i]);
            subsets(nums, result, currentList, i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }
}
