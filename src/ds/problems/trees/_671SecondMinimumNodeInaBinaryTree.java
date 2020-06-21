package ds.problems.trees;
//https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
//671. Second Minimum Node In a Binary Tree

public class _671SecondMinimumNodeInaBinaryTree {

    int firstMin = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    boolean seenMoreThanOnce = false;
    int original = -1;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        original = root.val;
        dfs(root);
        if (firstMin == secondMin || !seenMoreThanOnce) {
            return -1;
        }
        return secondMin;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val != original) {
            seenMoreThanOnce = true;
        }
        if (root.val < firstMin) {
            secondMin = firstMin;
            firstMin = root.val;
        }
        if (root.val < secondMin && root.val != firstMin) {
            secondMin = root.val;
        }
        dfs(root.left);
        dfs(root.right);
    }

}
