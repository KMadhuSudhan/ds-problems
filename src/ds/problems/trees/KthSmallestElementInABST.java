package ds.problems.trees;
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//230. Kth Smallest Element in a BST

import java.util.Stack;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        int count = 0;
        while(true) {
            if(root!=null) {
                stack.push(root);
                root = root.left;
            } else {
                if(stack.isEmpty()) break;
                count++;
                TreeNode top = stack.pop();
                if(count == k) return top.val;
                root = top.right;
            }
        }
        return -1;
    }
}
