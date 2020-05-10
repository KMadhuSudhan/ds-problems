package ds.problems.math;
//https://leetcode.com/problems/combination-sum-ii/
//40. Combination Sum II

import java.util.*;

public class _40CombinationSumII {

    public static void main(String[] args) {
        _40CombinationSumII combinationSumII = new _40CombinationSumII();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        combinationSumII.combinationSum2(nums, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> sublist = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, result, sublist, target, 0);
        return result;
    }

    private void combinationSum2(int[] candidates, List<List<Integer>> result, ArrayList<Integer> currentList, int sum, int start) {
        if (sum < 0) return;
        if (sum == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(i!=start && candidates[i] == candidates[i-1] || candidates[i] > sum) continue;
            currentList.add(candidates[i]);
            combinationSum2(candidates, result, currentList, sum - candidates[i], i+1);
            currentList.remove(currentList.size() - 1);
        }
    }
}
