package ds.problems.trees;
//https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
//1261. Find Elements in a Contaminated Binary Tree

import java.util.HashSet;
import java.util.Set;

public class _1261FindElementsInAContaminatedBinaryTree {
    Set<Integer> set;
    public _1261FindElementsInAContaminatedBinaryTree(TreeNode root) {
        set = new HashSet();
        recover(root,0,set);
    }

    private void recover(TreeNode root, int val, Set<Integer> set) {
        if (root==null)
            return;
        set.add(val);
        recover(root.left, 2 * val + 1, set);
        recover(root.right, 2 * val + 2, set);
    }


    public boolean find(int target) {
        return set.contains(target);
    }
}
