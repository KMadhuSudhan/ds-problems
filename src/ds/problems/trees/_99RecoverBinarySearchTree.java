package ds.problems.trees;
//https://leetcode.com/problems/recover-binary-search-tree/
//99. Recover Binary Search Tree

public class _99RecoverBinarySearchTree {

    TreeNode first = null,second = null;
    TreeNode previous = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(first!=null && second!=null) {
            int temp = second.val;
            second.val = first.val;
            first.val = temp;
        }
    }

    public void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(previous!=null && previous.val > root.val) {
            if(first == null) first = previous;
            second = root;
        }
        previous = root;
        inorder(root.right);
    }
}
