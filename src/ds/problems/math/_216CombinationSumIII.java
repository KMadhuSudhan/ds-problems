package ds.problems.math;
//https://leetcode.com/problems/combination-sum-iii/
//216. Combination Sum III

import java.util.ArrayList;
import java.util.List;

public class _216CombinationSumIII {
    public static void main(String[] args) {
        _216CombinationSumIII combinationSumIII = new _216CombinationSumIII();
        combinationSumIII.combinationSum3(3,7);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(nums,result,new ArrayList<>(),k,n,0);
        return result;
    }

    public void combinationSum3(int[] nums,List<List<Integer>> result,List<Integer> currentList,int k,int sum,int start) {
        if(sum < 0) return;
        if(sum == 0 && currentList.size() == k) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i=start;i<nums.length;i++){
            currentList.add(nums[i]);
            combinationSum3(nums,result,currentList,k,sum - nums[i],i+1);
            currentList.remove(currentList.size()-1);
        }
    }
}
