package ds.problems.math;
//https://leetcode.com/problems/subsets/
//78. Subsets

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/subsets/
//78. Subsets

public class _78Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        _78Subsets subsets = new _78Subsets();
        System.out.println(subsets.subsets(nums));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsets(nums, ans,new ArrayList<>(),0);
        return ans;
    }
    void subsets(int[] nums,List<List<Integer>> result,List<Integer> currentList,int start) {
        result.add(new ArrayList<>(currentList));
        for(int i=start;i<nums.length;i++) {
            currentList.add(nums[i]);
            subsets(nums,result,currentList,i+1);
            currentList.remove(currentList.size()-1);
        }
    }
}
