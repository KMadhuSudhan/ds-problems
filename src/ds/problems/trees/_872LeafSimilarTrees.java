package ds.problems.trees;
//https://leetcode.com/problems/leaf-similar-trees/
//872. Leaf-Similar Trees

import java.util.ArrayList;
import java.util.List;

public class _872LeafSimilarTrees {
    List<Integer> seq1;
    List<Integer> seq2;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        seq1 = new ArrayList();
        seq2 = new ArrayList();
        dfs(root1,seq1);
        dfs(root2,seq2);
        return seq1.equals(seq2);
    }

    void dfs(TreeNode root,List<Integer> seq) {
        if(root == null) return;

        dfs(root.left,seq);
        if(root.left == null && root.right == null) {
            seq.add(root.val);
        }
        dfs(root.right,seq);
    }
}
