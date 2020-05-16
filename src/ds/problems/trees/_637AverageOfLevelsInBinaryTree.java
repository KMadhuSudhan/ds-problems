package ds.problems.trees;
//https://leetcode.com/problems/average-of-levels-in-binary-tree/
//637. Average of Levels in Binary Tree

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _637AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Double largeSum = Double.valueOf(0);
            int totalSize = size;
            while(size -- >0) {
                TreeNode top = queue.poll();
                largeSum+=top.val;
                if(top.left!=null) {
                    queue.add(top.left);
                }
                if(top.right!=null) {
                    queue.add(top.right);
                }
            }
            Double avg = (double) largeSum / (double) totalSize;
            list.add( avg);
        }
        return list;
    }
}
