package ds.problems.math;

import java.util.*;

public class _39CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        _39CombinationSum combinationSum = new _39CombinationSum();
        combinationSum.combinationSum(nums,7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> subsets = new ArrayList<>();
        combinationSum(candidates, subsets,new ArrayList<>(),0,target);
        return subsets;
    }

    void combinationSum(int[] nums, List<List<Integer>> result, ArrayList<Integer> currentList, int start,int sum) {
        if(sum < 0) return;
        if(sum == 0) {
            result.add((ArrayList) currentList.clone());
            return;
        }
        for(int i=start;i<nums.length;i++) {
            currentList.add(nums[i]);
            combinationSum(nums, result, currentList, i ,sum - nums[i]);
            currentList.remove(currentList.size() - 1);
        }
    }
}
