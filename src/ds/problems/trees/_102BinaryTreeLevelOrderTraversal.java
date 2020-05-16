package ds.problems.trees;
//https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/
//102. Binary Tree Level Order Traversal

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList();
            while(size -- >0) {
                TreeNode top = queue.poll();
                level.add(top.val);
                if(top.left!=null) {
                    queue.add(top.left);
                }
                if(top.right!=null) {
                    queue.add(top.right);
                }
            }
            list.add(level);
        }
        return list;
    }
}
