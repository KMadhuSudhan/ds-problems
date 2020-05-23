package ds.problems.linkedlist;
//https://leetcode.com/problems/linked-list-in-binary-tree/
//1367. Linked List in Binary Tree

import ds.problems.trees.TreeNode;

public class _1367LinkedListinBinaryTree {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null){
            return head == null;
        }
        return dfs(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
    }

    public boolean dfs(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null || head.val!=root.val) {
            return false;
        }
        return dfs(head.next,root.left) || dfs(head.next,root.right);
    }

}
