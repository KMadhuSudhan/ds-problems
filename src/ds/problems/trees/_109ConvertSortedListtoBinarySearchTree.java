package ds.problems.trees;
//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
//109. Convert Sorted List to Binary Search Tree

import ds.problems.linkedlist.ListNode;

public class _109ConvertSortedListtoBinarySearchTree {

    ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        node = head;
        return buildBst(length(head));
    }

    TreeNode buildBst(int len) {
        if (len == 0) return null;
        TreeNode leftNode = buildBst(len / 2);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        root.left = leftNode;
        root.right = buildBst(len - len / 2 - 1);
        return root;
    }

    public int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
