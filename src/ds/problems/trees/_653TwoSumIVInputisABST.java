package ds.problems.trees;
//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
//653. Two Sum IV - Input is a BST

import java.util.HashSet;
import java.util.Set;

public class _653TwoSumIVInputisABST {

    Set<Integer> set = new HashSet();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        if(set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        boolean foundLeft = findTarget(root.left,k);
        boolean foundRight = findTarget(root.right,k);
        return foundLeft ||  foundRight;
    }
}
