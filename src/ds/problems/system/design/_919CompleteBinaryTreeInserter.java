package ds.problems.system.design;

import ds.problems.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _919CompleteBinaryTreeInserter {

    List<TreeNode> list = new ArrayList();
    public _919CompleteBinaryTreeInserter(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr == null) continue;
            list.add(curr);
            queue.add(curr.left);
            queue.add(curr.right);
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        list.add(node);
        TreeNode parent = list.get((list.size()-2 ) / 2);
        if(parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return list.get(0);
    }

}
