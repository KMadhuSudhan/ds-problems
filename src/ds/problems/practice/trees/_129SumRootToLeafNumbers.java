package ds.problems.practice.trees;
//https://leetcode.com/problems/sum-root-to-leaf-numbers/
//129. Sum Root to Leaf Numbers

import ds.problems.trees.StringToTreeNode;
import ds.problems.trees.TreeNode;

public class _129SumRootToLeafNumbers {
    int totalSum = 0,sum = 0,base = 1;
    public static void main(String[] args) {
        _129SumRootToLeafNumbers sumRootToLeafNumbers = new _129SumRootToLeafNumbers();
        StringToTreeNode stringToTreeNode = new StringToTreeNode();
        TreeNode root =  stringToTreeNode.stringToTreeNode("[4,9,0,5,1]");
        sumRootToLeafNumbers.sumNumbers(root);
    }
    public int sumNumbers(TreeNode root) {
        findSum(root);
        return totalSum;
    }

    public void findSum(TreeNode root) {
        if(root == null) return;
        int prevSum = sum;
        sum =  sum*10 + root.val;
        if(root.left == null && root.right == null) {
            totalSum+= sum;
            sum = prevSum;
            return;
        }
        findSum(root.left);
        findSum(root.right);
        sum = sum/10 - root.val;
    }
}
