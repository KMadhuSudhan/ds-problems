package ds.problems.trees;
//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
//1161. Maximum Level Sum of a Binary Tree

import java.util.LinkedList;
import java.util.Queue;

public class _1161MaximumLevelSumofaBinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int maxSum = 0;
        int level = 0;
        int maxLevel =0;
        while(!q.isEmpty()) {
            int sum = 0;
            int size = q.size();
            level++;
            while(size -- > 0 ) {
                TreeNode node = q.poll();
                sum+=node.val;
                if(node.left!=null) {
                    q.offer(node.left);
                }
                if(node.right!=null) {
                    q.offer(node.right);
                }
            }
            if(maxSum < sum) {
                maxSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
