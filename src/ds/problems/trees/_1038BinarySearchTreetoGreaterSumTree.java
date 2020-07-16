package ds.problems.trees;
//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
//1038. Binary Search Tree to Greater Sum Tree

public class _1038BinarySearchTreetoGreaterSumTree {

    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode root) {
        if(root == null) return;
        helper(root.right);
        sum+=root.val;
        root.val = sum ;
        helper(root.left);
    }
}
