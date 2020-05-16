package ds.problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/n-ary-tree-level-order-traversal/
//429. N-ary Tree Level Order Traversal

public class _429NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList();
        if(root == null) return list;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList();
            while(size -- >0) {
                Node top = queue.poll();
                level.add(top.val);
                if(top.children!=null) {
                    for(Node node: top.children) {
                        if(node!=null) queue.add(node);
                    }
                }
            }
            list.add(level);
        }
        return list;
    }
}
