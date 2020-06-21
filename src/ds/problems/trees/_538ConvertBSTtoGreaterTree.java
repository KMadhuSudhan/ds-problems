package ds.problems.trees;
//https://leetcode.com/problems/convert-bst-to-greater-tree/
//538. Convert BST to Greater Tree

public class _538ConvertBSTtoGreaterTree {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        convertBST(root.right);
        sum+=root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
