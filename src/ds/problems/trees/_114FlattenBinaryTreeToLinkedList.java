package ds.problems.trees;
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//114. Flatten Binary Tree to Linked List

import java.util.Stack;

public class _114FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode tmp = root;
        Stack<TreeNode> stack = new Stack();
        while(tmp!=null) {
            if(tmp.right!=null) {
                stack.push(tmp.right);
            }
            tmp.right = tmp.left;
            if(!stack.isEmpty() && tmp.left == null) {
                TreeNode top = stack.pop();
                tmp.right = top;
                tmp = top;
            } else {
                TreeNode left = tmp.left;
                tmp.left = null;
                tmp = left;
            }
        }
    }
}
