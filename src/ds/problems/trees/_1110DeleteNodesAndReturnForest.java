package ds.problems.trees;
//https://leetcode.com/problems/delete-nodes-and-return-forest/
//1110. Delete Nodes And Return Forest

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1110DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList();
        Set<Integer> set = new HashSet();
        for(int node: to_delete) {
            set.add(node);
        }
        if(!set.contains(root.val)) forest.add(root);
        dfs(root,null,set,forest);
        return forest;
    }

    void dfs(TreeNode root ,TreeNode parent,Set<Integer> set,List<TreeNode> forest) {
        if(root == null) {
            return;
        }
        dfs(root.left,root,set,forest);
        dfs(root.right,root,set,forest);
        if(set.contains(root.val)) {
            if(root.left!=null && !set.contains(root.left.val)){
                forest.add(root.left);
            }

            if(root.right!=null && !set.contains(root.right.val)){
                forest.add(root.right);
            }
            if(parent!=null) {
                if(root == parent.left) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
    }
}
