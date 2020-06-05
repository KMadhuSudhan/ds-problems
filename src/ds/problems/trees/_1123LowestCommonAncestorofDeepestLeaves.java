package ds.problems.trees;
//https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
//1123. Lowest Common Ancestor of Deepest Leaves

public class _1123LowestCommonAncestorofDeepestLeaves {

    int maxDepth = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return lcaDeepestLeaves(root,depth(root),1);
    }
    int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right))+1;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root,int depth,int currentDepth) {
        if(root == null) {
            return null;
        }
        if(depth == currentDepth) {
            return root;
        }
        TreeNode leftLca =  lcaDeepestLeaves(root.left,depth,currentDepth+1);
        TreeNode rightLca =  lcaDeepestLeaves(root.right,depth,currentDepth+1);
        if(leftLca !=null&&rightLca!=null) {
            return root;
        }
        return leftLca!=null?  leftLca : rightLca;
    }
}
