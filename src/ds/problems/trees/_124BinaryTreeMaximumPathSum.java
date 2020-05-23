package ds.problems.trees;
//https://leetcode.com/problems/binary-tree-maximum-path-sum/
//124. Binary Tree Maximum Path Sum

public class _124BinaryTreeMaximumPathSum {
    int maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxSum(root);
        return maxsum;
    }

    public int getMaxSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftsum = getMaxSum(root.left);
        int rightsum = getMaxSum(root.right);

        int maxForThisCall = Math.max(root.val,root.val+Math.max(leftsum,rightsum));

        maxsum = Math.max(maxsum, maxForThisCall);
        maxsum = Math.max(maxsum, root.val + leftsum + rightsum);

        //return sum of this subtree in recursive call
        return maxForThisCall;
    }
}
