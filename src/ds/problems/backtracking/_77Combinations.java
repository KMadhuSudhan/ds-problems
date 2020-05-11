package ds.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations/
//77. Combinations

public class _77Combinations {

    public static void main(String[] args) {
        _77Combinations combinations = new _77Combinations();
        combinations.combine(4,2);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        combinations(1,n,k, result,new ArrayList());
        return result;
    }

    public void combinations(int start,int end,int k,List<List<Integer>> result,List<Integer> currentList) {
        if(currentList.size()>k) return;
        if(currentList.size() == k){
            result.add(new ArrayList(currentList));
            return;
        }
        for(int i=start;i<=end;i++) {
            currentList.add(i);
            combinations(i+1,end,k,result,currentList);
            currentList.remove(currentList.size()-1);
        }
    }
}
