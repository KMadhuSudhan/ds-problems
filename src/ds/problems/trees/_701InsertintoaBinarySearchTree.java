package ds.problems.trees;
//https://leetcode.com/problems/insert-into-a-binary-search-tree/
//701. Insert into a Binary Search Tree

public class _701InsertintoaBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
        } else {
            if(val <= root.val) {
                root.left = insertIntoBST(root.left,val);
            } else {
                root.right = insertIntoBST(root.right,val);
            }
        }
        return root;
    }
}
