package ds.problems.trees;
//https://leetcode.com/problems/deepest-leaves-sum/
//1302. Deepest Leaves Sum

public class _1302DeepestLeavesSum {

    int maxDepth = -1;
    int maxDepthSum = 0;
    public int deepestLeavesSum(TreeNode root) {
        deepestLeavesSum(root,0);
        return maxDepthSum;
    }

    public void deepestLeavesSum(TreeNode root,int depth) {
        if(root == null) {
            return ;
        }
        if(maxDepth < depth) {
            maxDepth = depth;
            maxDepthSum = 0;
        }
        if(maxDepth == depth) {
            maxDepthSum+=root.val;
        }
        deepestLeavesSum(root.left,depth+1);
        deepestLeavesSum(root.right,depth+1);
    }
}
