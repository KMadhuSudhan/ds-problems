package ds.problems.trees;
//https://leetcode.com/problems/unique-binary-search-trees-ii/
//95. Unique Binary Search Trees II

import java.util.ArrayList;
import java.util.List;

public class _95UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        _95UniqueBinarySearchTreesII uniqueBinarySearchTreesII = new _95UniqueBinarySearchTreesII();
        uniqueBinarySearchTreesII.generateTrees(5);
    }
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList();
        return constructTree(1,n);
    }

    List<TreeNode> constructTree(int start,int end) {
        List<TreeNode> list = new ArrayList();
        if(start>end) {
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++) {
            List<TreeNode> leftSubTree =  constructTree(start,i-1);
            List<TreeNode> rightSubTree =  constructTree(i+1,end);
            for(int j=0;j<leftSubTree.size();j++) {
                TreeNode left = leftSubTree.get(j);
                for(int k=0;k<rightSubTree.size();k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = rightSubTree.get(k);
                    list.add(root);
                }
            }
        }
        return list;
    }
}
