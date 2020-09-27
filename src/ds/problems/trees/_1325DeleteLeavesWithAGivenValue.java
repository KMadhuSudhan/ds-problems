package ds.problems.trees;
//https://leetcode.com/problems/delete-leaves-with-a-given-value/
//1325. Delete Leaves With a Given Value

public class _1325DeleteLeavesWithAGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return null;
        dfs(root,target);
        if(root.left == null && root.right == null && root.val == target) return null;
        return root;
    }

    public void dfs(TreeNode root, int target) {
        if(root == null) return;
        dfs(root.left,target);
        dfs(root.right,target);
        if(root.left != null && root.left.left == null && root.left.right == null && root.left.val == target) {
            root.left = null;
        }
        if(root.right != null && root.right.left == null && root.right.right == null && root.right.val == target) {
            root.right = null;
        }
    }
}
