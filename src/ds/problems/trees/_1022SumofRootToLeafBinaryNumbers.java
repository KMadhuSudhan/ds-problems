package ds.problems.trees;
//https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
//1022. Sum of Root To Leaf Binary Numbers

import java.util.ArrayList;
import java.util.List;

public class _1022SumofRootToLeafBinaryNumbers {

    List<String> paths = new ArrayList();
    public int sumRootToLeaf(TreeNode root) {
        getAllPaths(root,new StringBuilder());
        return getSum(paths);
    }

    public void getAllPaths(TreeNode root,StringBuilder currentPath) {
        if(root == null) return;
        int length = currentPath.length();
        currentPath.append(root.val);
        if(root.left == null && root.right == null) {
            paths.add(currentPath.toString());
        }
        getAllPaths(root.left,currentPath);
        getAllPaths(root.right,currentPath);
        currentPath.delete(length,currentPath.length());
    }
    int getSum(List<String> paths) {
        int sum = 0;
        for(String str: paths) {
            int base = 1;
            char[] strChars = str.toCharArray();
            int currentSum = 0;
            for(int i=strChars.length-1;i>=0;i--) {
                if(strChars[i] == '1') {
                    currentSum += base;
                }
                base*=2;
            }
            sum+=currentSum;
        }
        return sum;
    }
}
