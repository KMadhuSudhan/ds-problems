package ds.problems.backtracking;
//https://leetcode.com/problems/permutations-ii/
//47. Permutations II

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _47PermutationsII {

    public static void main(String[] args) {
        _47PermutationsII permutationsII = new _47PermutationsII();
        int[] nums = {1,1,2};
        permutationsII.permuteUnique(nums);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutations(nums,result,0);
        return new ArrayList(result);
    }

    public void permutations(int[] nums, List<List<Integer>> result, int start) {
        if(start == nums.length) {
            result.add(copyArrayToList(nums));
        } else {
            HashSet<Integer> set = new HashSet<>();
            for(int i=start;i<nums.length;i++) {
                if(!set.add(nums[i])) continue;
                swap(nums,start,i);
                permutations(nums,result,start+1);
                swap(nums,start,i);
            }
        }
    }
    public List<Integer> copyArrayToList(int[] input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            result.add(input[i]);
        }
        return result;
    }

    void swap(int[] nums,int i,int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
