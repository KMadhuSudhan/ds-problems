package ds.problems.trees;
//https://leetcode.com/problems/univalued-binary-tree/
//965. Univalued Binary Tree

public class _965UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        return isUnivalTree(root,root.val);
    }

    public boolean isUnivalTree(TreeNode root,int val) {
        if(root == null) return true;
        return root.val == val && isUnivalTree(root.left,val) && isUnivalTree(root.right,val);
    }
}
