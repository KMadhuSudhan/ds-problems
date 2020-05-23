package ds.problems.trees;
//https://leetcode.com/problems/find-bottom-left-tree-value/
//513. Find Bottom Left Tree Value

public class _513FindBottomLeftTreeValue {
    int maxDepth = 0;
    int val = 0;
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return root.val;
        }
        findBottomLeftValue(root,1);
        return val;
    }

    public void findBottomLeftValue(TreeNode root,int d) {
        if(root == null) return;
        if(maxDepth < d) {
            maxDepth = d;
            val = root.val;
        }
        findBottomLeftValue(root.left,d+1);
        findBottomLeftValue(root.right,d+1);
    }
}
