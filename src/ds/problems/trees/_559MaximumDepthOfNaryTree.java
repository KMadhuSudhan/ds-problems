package ds.problems.trees;
//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
//559. Maximum Depth of N-ary Tree

import java.util.LinkedList;
import java.util.Queue;

public class _559MaximumDepthOfNaryTree {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size -- >0) {
                Node top = queue.poll();
                if(top.children!=null)  {
                    for(Node node: top.children) {
                        queue.add(node);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
