package ds.problems.trees;
//https://leetcode.com/problems/diameter-of-binary-tree/
//543. Diameter of Binary Tree

import com.sun.tools.hat.internal.model.HackJavaValue;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {

    }
    public int diameterOfBinaryTreeWihN2(TreeNode root) {
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        int ld = diameterOfBinaryTreeWihN2(root.left);
        int rd = diameterOfBinaryTreeWihN2(root.right);
        int max = Math.max(lh+rh +1 , Math.max(ld,rd));
        return max;
    }

    int height(TreeNode root) {
        if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        return 1 + Math.max(l,r);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Height height = new Height();
        return diameterOfBinaryTree(root);
    }

    public int diameterOfBinaryTree(TreeNode root,Height height) {
        Height lh = new Height();
        Height rh = new Height();
        if(root == null) {
            height.h = 0;
            return 0;
        }
        int ld = diameterOfBinaryTree(root.left,lh);
        int rd = diameterOfBinaryTree(root.right,rh);
        height.h = Math.max(lh.h, rh.h) + 1;
        int max = Math.max(lh.h + rh.h + 1, Math.max(ld,rd));
        return max;
    }

    class Height {
        int h;
    }
}
