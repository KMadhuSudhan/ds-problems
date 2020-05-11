package ds.problems.backtracking;
//https://leetcode.com/problems/permutation-sequence/
//60. Permutation Sequence

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/permutation-sequence/
//60. Permutation Sequence

public class _60PermutationSequence {
    public static void main(String[] args) {
        _60PermutationSequence permutationSequence = new _60PermutationSequence();
        System.out.println(permutationSequence.getPermutation(4,9));
    }

    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] fact = new int[n+1];
        fact[0] = 1;
        for (int i=1;i<=n;i++) {
            fact[i] = i *fact[i-1];
        }
        for (int i=0;i<n;i++) {
            nums.add(i+1);
        }
        return helper(n,k-1,nums,fact);
    }

    public String helper(int n,int k,List<Integer> nums,int[] fact) {
        if(n<0) return "";
        int index =  n-1 <0 ? 1 : k/fact[n-1];
        if(index >= nums.size()) return "";
        String res = ""  + nums.get(index);
        nums.remove(index);
        return res + helper(n-1,k-index*fact[n-1],nums,fact);
    }
}
