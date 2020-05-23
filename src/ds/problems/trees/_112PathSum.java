package ds.problems.trees;
//https://leetcode.com/problems/path-sum/
//112. Path Sum

public class _112PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && (sum - root.val) == 0) {
            return true;
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}
