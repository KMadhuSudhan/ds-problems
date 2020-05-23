package ds.problems.trees;
//https://leetcode.com/problems/path-sum-ii/
//113. Path Sum II

import java.util.ArrayList;
import java.util.List;

public class _113PathSumII {

    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return ans;
        pathSum(root,sum,new ArrayList());
        return ans;
    }

    public void pathSum(TreeNode root, int sum,List<Integer> currentPath) {
        if(root == null) return;
        currentPath.add(root.val);
        pathSum(root.left,sum - root.val,currentPath);
        if(root.left == null && root.right == null && (sum - root.val) == 0) {
            ans.add( new ArrayList(currentPath));
        }
        pathSum(root.right,sum - root.val,currentPath);
        currentPath.remove(currentPath.size()-1);
    }
}
