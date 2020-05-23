package ds.problems.trees;
//https://leetcode.com/problems/binary-tree-paths/
//257. Binary Tree Paths

import java.util.ArrayList;
import java.util.List;

public class _257BinaryTreePaths {

    List<String> ans = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return ans;
        binaryTreePaths(root,new StringBuilder());
        return ans;
    }

    public void binaryTreePaths(TreeNode root,StringBuilder currentPath) {
        if(root == null) return;
        currentPath.append(root.val);
        if(root.left == null && root.right == null) {
            ans.add(currentPath.toString());
        } else {
            currentPath.append("->");
        }
        binaryTreePaths(root.left,currentPath);
        binaryTreePaths(root.right,currentPath);
    }
    /* with ds.problems.string builder
     List<String> ans = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return ans;
        binaryTreePaths(root,new StringBuilder());
        return ans;
    }

    public void binaryTreePaths(TreeNode root,StringBuilder currentPath) {
       if(root == null) return;
        int tmp = currentPath.length();
        if(root.left == null && root.right == null){
            currentPath.append(root.val);
            ans.add(currentPath.toString());
            currentPath.delete(tmp , currentPath.length());
            return;
        }
        currentPath.append(root.val + "->");
        binaryTreePaths(root.left,currentPath);
        binaryTreePaths(root.right,currentPath);
        currentPath.delete(tmp , currentPath.length());
    }
     */
}
