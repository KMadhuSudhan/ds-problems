package ds.problems.trees;
//https://leetcode.com/problems/subtree-of-another-tree/
//572. Subtree of Another Tree

public class _572SubtreeofAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(s.val == t.val) {
            if(dfs(s,t)) {
                return true;
            }
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    boolean dfs(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        return s!=null && t!=null && s.val == t.val && dfs(s.left,t.left) && dfs(s.right,t.right);
    }
}
