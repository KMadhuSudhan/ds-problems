package ds.problems.trees;
//https://leetcode.com/problems/invert-binary-tree/
//226. Invert Binary Tree

public class _226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }
}
