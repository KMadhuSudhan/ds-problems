package ds.problems.trees;
//https://leetcode.com/problems/balance-a-binary-search-tree/
//1382. Balance a Binary Search Tree

import java.util.ArrayList;
import java.util.List;

public class _1382BalanceaBinarySearchTree {

    List<Integer> list = new ArrayList();
    public TreeNode balanceBST(TreeNode root) {
        helper(root);
        return balanceBST(root,0,list.size()-1);
    }

    public TreeNode balanceBST(TreeNode root,int start,int end) {
        if(start>end) return null;
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = balanceBST(root,start,mid-1);
        node.right = balanceBST(root,mid+1,end);
        return node;
    }

    void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}
