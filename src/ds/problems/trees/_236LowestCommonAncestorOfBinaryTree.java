package ds.problems.trees;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
//236. Lowest Common Ancestor of a Binary Tree

public class _236LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) {
            return root;
        }
        return left!=null ? left : right ;
    }
}
