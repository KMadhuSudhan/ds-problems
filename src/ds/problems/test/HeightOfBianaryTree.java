package ds.problems.test;

import ds.problems.trees.TreeNode;

public class HeightOfBianaryTree {
    private int height(TreeNode root) {
        if(root == null) return 0;
        int lh = height(root.left);
        int rh  = height(root.right);
        return 1 + Math.max(lh,rh);
    }
}
