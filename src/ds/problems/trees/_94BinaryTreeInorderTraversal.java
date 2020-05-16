package ds.problems.trees;
//https://leetcode.com/problems/binary-tree-inorder-traversal/
//94. Binary Tree Inorder Traversal

import java.util.ArrayList;
import java.util.List;

public class _94BinaryTreeInorderTraversal {
    List<Integer> ans = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return ans;
        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);
        return ans;
    }
}
