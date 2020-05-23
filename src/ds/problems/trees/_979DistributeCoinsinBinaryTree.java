package ds.problems.trees;
//https://leetcode.com/problems/distribute-coins-in-binary-tree/
//979. Distribute Coins in Binary Tree

public class _979DistributeCoinsinBinaryTree {

    int ans = 0;
    public int distributeCoins(TreeNode root) {
        distribute(root);
        return ans;
    }

    public int distribute(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = distribute(root.left);
        int right = distribute(root.right);
        ans += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
