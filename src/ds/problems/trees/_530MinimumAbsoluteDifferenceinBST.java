package ds.problems.trees;
//https://leetcode.com/problems/minimum-absolute-difference-in-bst/
//530. Minimum Absolute Difference in BST

public class _530MinimumAbsoluteDifferenceinBST {
    int minDiff = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(prev!=Integer.MAX_VALUE) {
            minDiff = Math.min(minDiff,Math.abs(prev-root.val));
        }
        prev = root.val;
        inorder(root.right);
    }
}
