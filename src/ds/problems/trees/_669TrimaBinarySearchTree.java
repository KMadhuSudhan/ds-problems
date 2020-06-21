package ds.problems.trees;
//https://leetcode.com/problems/trim-a-binary-search-tree/
//669. Trim a Binary Search Tree

public class _669TrimaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        int val = root.val;
        if (val < L) return trimBST(root.right, L, R);
        if (val > R) return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
