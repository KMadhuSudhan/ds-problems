package ds.problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class _1609EvenOddTree {
    public static void main(String[] args) {

    }

    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) return true;
        if(root.val %2 == 0) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = (level+1) % 2 == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode parent = queue.poll();
                if ((level+1) % 2 == 0) {
                    if (parent.left != null) {
                        if (parent.left.val > start && parent.left.val%2 == 1) {
                            start = parent.left.val;
                            queue.offer(parent.left);
                        } else {
                            return false;
                        }
                    }
                    if (parent.right != null) {
                        if (parent.right.val > start && parent.right.val%2 == 1) {
                            start = parent.right.val;
                            queue.offer(parent.right);
                        } else {
                            return false;
                        }
                    }
                } else {
                    if (parent.left != null) {
                        if (parent.left.val < start && parent.left.val%2 == 0) {
                            start = parent.left.val;
                            queue.offer(parent.left);
                        } else {
                            return false;
                        }
                    }
                    if (parent.right != null) {
                        if (parent.right.val < start &&  parent.right.val%2 == 0) {
                            start = parent.right.val;
                            queue.offer(parent.right);
                        } else {
                            return false;
                        }
                    }
                }
            }
            level++;
        }
        return true;
    }
}
