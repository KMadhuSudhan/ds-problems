package ds.problems.trees;
//https://leetcode.com/problems/delete-node-in-a-bst/
//450. Delete Node in a BST

public class _450DeleteNodeinaBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val) {
            root.left = deleteNode(root.left,key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right,key);
        } else {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            root.val = minValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    int minValue(TreeNode root) {
        while (root.left!=null) {
            root = root.left;
        }
        return root.val;
    }

}
