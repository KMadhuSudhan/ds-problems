package ds.problems.trees;
//https://leetcode.com/problems/binary-tree-preorder-traversal/
//144. Binary Tree Preorder Traversal

import java.util.ArrayList;
import java.util.List;

public class _144BinaryTreePreorderTraversal {

    List<Integer> ans = new ArrayList();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return ans;
        preOrder(root);
        return ans;
    }

    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        ans.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
