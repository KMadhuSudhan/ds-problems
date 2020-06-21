package ds.problems.trees;
//https://leetcode.com/problems/check-completeness-of-a-binary-tree/
//958. Check Completeness of a Binary Tree

import java.util.LinkedList;
import java.util.Queue;

public class _958CheckCompletenessofaBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean nullFound = false;
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if(current == null) {
                nullFound = true;
                continue;
            } else if(nullFound) {
                return false;
            }
            queue.add(current.left);
            queue.add(current.right);
        }
        return true;
    }
}
