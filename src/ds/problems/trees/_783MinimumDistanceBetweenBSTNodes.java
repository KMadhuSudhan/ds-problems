package ds.problems.trees;
//https://leetcode.com/problems/minimum-distance-between-bst-nodes/
//783. Minimum Distance Between BST Nodes

public class _783MinimumDistanceBetweenBSTNodes {

    int minDiff = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
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
