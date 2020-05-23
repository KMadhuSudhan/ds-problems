package ds.problems.trees;
//https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
//1080. Insufficient Nodes in Root to Leaf Paths

import java.util.Comparator;
import java.util.Map;

public class _1080InsufficientNodesinRoottoLeafPaths {
    TreeNode sumTreeNode = null;
    public static void main(String[] args) {
        StringToTreeNode stringToTreeNode = new StringToTreeNode();
        TreeNode treeNode = stringToTreeNode.stringToTreeNode("[5,4,8,11,null,17,4,7,1,null,null,5,3]");
        _1080InsufficientNodesinRoottoLeafPaths insufficientNodesinRoottoLeafPaths = new  _1080InsufficientNodesinRoottoLeafPaths();
        insufficientNodesinRoottoLeafPaths.sufficientSubset(treeNode,22);
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root == null) return null;
        if(dfs(root,limit,0)) {
            return null;
        }
        return root;
    }
    public boolean  dfs(TreeNode root,int limit,int pathSum) {
        if(root == null) return true;
        pathSum = pathSum + root.val;
        if(root.left == null && root.right == null) {
            return pathSum < limit;
        }
        boolean deleteLeft = dfs(root.left,limit,pathSum);
        boolean deleteRight  = dfs(root.right,limit,pathSum);
        if(deleteLeft) {
            root.left = null;
        }
        if(deleteRight) {
            root.right = null;
        }
        if(deleteLeft && deleteRight) {
            return true;
        }
        return false;
    }
}
