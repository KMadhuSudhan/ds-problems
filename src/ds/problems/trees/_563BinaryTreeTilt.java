package ds.problems.trees;
//https://leetcode.com/problems/binary-tree-tilt/
//563. Binary Tree Tilt

public class _563BinaryTreeTilt {
    public static void main(String[] args) {
        StringToTreeNode stringToTreeNode = new StringToTreeNode();
        TreeNode treeNode = stringToTreeNode.stringToTreeNode("[1,2,3]");
        _563BinaryTreeTilt binaryTreeTilt = new _563BinaryTreeTilt();
        binaryTreeTilt.findTilt(treeNode);
    }
    int ans = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return ans;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;
        int old_val = root.val;
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        int subTreeSum = leftSum + rightSum;
        ans+= Math.abs(leftSum - rightSum);
        return subTreeSum + old_val;
    }

}
