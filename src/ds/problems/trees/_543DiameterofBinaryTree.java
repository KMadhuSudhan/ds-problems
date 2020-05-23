package ds.problems.trees;
//https://leetcode.com/problems/diameter-of-binary-tree
//543. Diameter of Binary Tree

public class _543DiameterofBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return diameterOfBinaryTree(root, new int[2])[0];
    }

    public int[] diameterOfBinaryTree(TreeNode root,int[] max) {
        if(root == null) return new int[2];
        int left = diameterOfBinaryTree(root.left, max)[1];
        int right = diameterOfBinaryTree(root.right, max)[1];
        max[0] = Math.max(max[0], left + right); // Calculate diameter at current node.
        max[1] = Math.max(left, right) + 1; // Calculate height at current node.
        return max;
    }
}
