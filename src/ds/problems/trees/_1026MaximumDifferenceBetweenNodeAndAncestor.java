package ds.problems.trees;
//https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
//1026. Maximum Difference Between Node and Ancestor

public class _1026MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        return dfs(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    int dfs(TreeNode root,int parent,int child) {
        if(root == null) return Math.abs(parent-child);
        parent = Math.max(parent,root.val);
        child = Math.min(child,root.val);
        return Math.max(dfs(root.left,parent,child),dfs(root.right,parent,child));
    }
}
