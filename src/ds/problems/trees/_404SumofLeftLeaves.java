package ds.problems.trees;
//https://leetcode.com/problems/sum-of-left-leaves/
//404. Sum of Left Leaves

public class _404SumofLeftLeaves {
    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        sum(root,false);
        return ans;
    }
    public void sum(TreeNode root,boolean isLeft) {
        if(root == null) return ;
        if(root.left == null && root.right == null && isLeft) {
            ans+=root.val;
        }
        sum(root.left,true);
        sum(root.right,false);
    }
}
