package ds.problems.trees;
//https://leetcode.com/problems/path-sum-iii/
//437. Path Sum III

import java.util.HashMap;
import java.util.Map;

public class _437PathSumIII {

    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0,1);
        pathSumCount (root, 0, sum, sumMap);
        return count;
    }

    public void pathSumCount (TreeNode node,  int sum, int target, Map<Integer,Integer> sumMap)
    {
        if (node == null) return;
        sum += node.val;
        if (sumMap.containsKey(sum - target))
        {
            count += sumMap.get(sum -target);
        }
        sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        pathSumCount (node.left, sum, target, sumMap);
        pathSumCount (node.right, sum,target, sumMap);
        sumMap.put(sum, sumMap.getOrDefault(sum, 0) - 1);
        sum -= node.val;
    }

}
