package ds.problems.trees;
//https://leetcode.com/problems/binary-tree-pruning/
//814. Binary Tree Pruning

public class _814BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        dfs(root);
        return root;
    }
    public boolean dfs(TreeNode root) {
        if(root == null) return false;
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if(!left) {
            root.left = null;
        }
        if(!right) {
            root.right = null;
        }
        if(!left && !right && root.val == 0) {
            return false;
        }
        return true;
    }

}
