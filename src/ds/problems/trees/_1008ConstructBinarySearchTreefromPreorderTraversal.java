package ds.problems.trees;
//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
//1008. Construct Binary Search Tree from Preorder Traversal

public class _1008ConstructBinarySearchTreefromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = {0};
        int max = Integer.MAX_VALUE;
        return helper(preorder, index, max);
    }

    private TreeNode helper(int[] preorder, int[] index, int max) {
        if (index[0] >= preorder.length || preorder[index[0]] >= max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;
        root.left = helper(preorder, index, root.val);
        root.right = helper(preorder, index, max);
        return root;
    }
}
