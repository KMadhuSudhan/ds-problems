package ds.problems.trees;
//https://leetcode.com/problems/house-robber-iii/
//337. House Robber III

public class _337HouseRobberIII {

    public int rob(TreeNode root) {
        int[] maxAmt = getMaxAmount(root);
        return Math.max(maxAmt[0],maxAmt[1]);
    }

    public int[] getMaxAmount(TreeNode root) {
        int[] result = new int[2];
        if(root == null) return result;
        int[] left = getMaxAmount(root.left);
        int[] right = getMaxAmount(root.right);

        //dont steal current node
        result[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        //steal current node
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}
