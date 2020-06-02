package ds.problems.trees;
//https://leetcode.com/problems/search-in-a-binary-search-tree/
//700. Search in a Binary Search Tree

public class _700SearchinaBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) return root;
        if(val<= root.val) {
            return searchBST(root.left,val);
        } else {
            return  searchBST(root.right,val);
        }
    }
}
