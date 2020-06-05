package ds.problems.trees;
//https://leetcode.com/problems/count-complete-tree-nodes/
//222. Count Complete Tree Nodes

import java.util.LinkedList;
import java.util.Queue;

public class _222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- >0) {
                TreeNode node = queue.poll();
                if(node.left!=null) {
                    queue.add(node.left);
                    count++;
                }
                if(node.right!=null) {
                    queue.add(node.right);
                    count++;
                }
            }
        }
        return count;
    }
}
