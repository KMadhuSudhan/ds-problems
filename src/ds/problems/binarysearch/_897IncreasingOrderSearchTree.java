package ds.problems.binarysearch;
//https://leetcode.com/problems/increasing-order-search-tree/
//897. Increasing Order Search Tree

import ds.problems.trees.TreeNode;

import java.util.Stack;

public class _897IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null) {
            stack.push(p);
            p = p.left;
        }
        TreeNode res = stack.pop();
        TreeNode tmp =res;
        addRightChild(stack,res);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            tmp.right = node;
            tmp.left = null;
            tmp = node;
            addRightChild(stack,node);
        }
        return res;
    }
    void addRightChild(Stack<TreeNode> stack,TreeNode node) {
        if(node.right!=null) {
             node = node.right;
            while (node!=null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
