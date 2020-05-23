package ds.problems.trees;
//https://leetcode.com/problems/find-largest-value-in-each-tree-row/
//515. Find Largest Value in Each Tree Row

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _515FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()) {
            int maxVal = Integer.MIN_VALUE;
            int size = q.size();
            while(size -- > 0) {
                TreeNode node = q.poll();
                maxVal = Math.max(maxVal, node.val);
                if(node.left!=null) {
                    q.offer(node.left);
                }
                if(node.right!=null) {
                    q.offer(node.right);
                }
            }
            ans.add(maxVal);
        }
        return ans;
    }
}
