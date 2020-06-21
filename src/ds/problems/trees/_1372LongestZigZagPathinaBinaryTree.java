package ds.problems.trees;
//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
//1372. Longest ZigZag Path in a Binary Tree

public class _1372LongestZigZagPathinaBinaryTree {
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left,1,true);
        dfs(root.right,1,false);
        return ans;
    }
    void dfs(TreeNode root,int prev,boolean isLeft) {
        if(root == null) {
            return ;
        }
        ans = Math.max(ans,prev);
        dfs(root.left,1 + (isLeft ? 0 : prev),true);
        dfs(root.right,1 + (isLeft ? prev : 0),false);
    }

}
