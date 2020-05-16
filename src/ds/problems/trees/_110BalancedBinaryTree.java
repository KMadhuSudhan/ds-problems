package ds.problems.trees;
//https://leetcode.com/problems/balanced-binary-tree/submissions/
//110. Balanced Binary Tree

public class _110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int l = height(root.left);
        int r = height(root.right);
        return Math.abs(l-r) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    int height(TreeNode root) {
        if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l,r)+1;
    }
}
