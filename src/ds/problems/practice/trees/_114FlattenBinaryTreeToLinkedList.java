package ds.problems.practice.trees;
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//114. Flatten Binary Tree to Linked List

import ds.problems.trees.StringToTreeNode;
import ds.problems.trees.TreeNode;

import java.util.Stack;

public class _114FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        StringToTreeNode stringToTreeNode = new StringToTreeNode();
        TreeNode root =  stringToTreeNode.stringToTreeNode("[1,null,2,3]");
        _114FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new _114FlattenBinaryTreeToLinkedList();
        flattenBinaryTreeToLinkedList.flatten(root);
    }

    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root,root);
    }

    public void flatten(TreeNode root,TreeNode parent) {
        if(root == null) return;
        TreeNode right = root.right;
        TreeNode left = root.left;
        parent.right = root.left;
        root.left = null;
        flatten(left,root);
        flatten(right,root);
    }
}
