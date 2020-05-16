package ds.problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
//107. Binary Tree Level Order Traversal II

public class _107BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            list.add(0,level);
        }
        return list;
    }
}
