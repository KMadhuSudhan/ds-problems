package ds.problems.trees;

//https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
//865. Smallest Subtree with all the Deepest Nodes

import java.util.LinkedList;
import java.util.List;

public class _865SmallestSubtreeWithAllDeepestNodes {

    TreeNode ans = null;
    int maxDepth = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        dfs(root,0);
        return ans;
    }

    int dfs(TreeNode root,int depth) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            if(depth> maxDepth) {
                ans = root;
                maxDepth = depth;
            }
            return depth;
        }
        int left = root.left!=null ? dfs(root.left , depth+1) : 0;
        int right = root.right!=null ? dfs(root.right , depth+1) : 0;
        if(right == left && left == maxDepth) {
            ans = root;
        }
        return Math.max(left,right);
    }
}
