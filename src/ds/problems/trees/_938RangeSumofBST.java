package ds.problems.trees;
//https://leetcode.com/problems/range-sum-of-bst/
//938. Range Sum of BST

public class _938RangeSumofBST {

    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) {
            return 0;
        }
        if(root.val>=L && root.val<=R) sum += root.val;
        rangeSumBST(root.left,L,R);
        rangeSumBST(root.right,L,R);
        return sum;
    }
}
