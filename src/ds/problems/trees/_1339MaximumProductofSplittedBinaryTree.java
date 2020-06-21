package ds.problems.trees;
//https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
//1339. Maximum Product of Splitted Binary Tree

public class _1339MaximumProductofSplittedBinaryTree {
    long ans = 0;
    public static void main(String[] args) {
        StringToTreeNode stringToTreeNode = new StringToTreeNode();
        TreeNode treeNode =  stringToTreeNode.stringToTreeNode("[1,2,3,4,5,6]");
        _1339MaximumProductofSplittedBinaryTree productofSplittedBinaryTree = new _1339MaximumProductofSplittedBinaryTree();
        int product = productofSplittedBinaryTree.maxProduct(treeNode);
        System.out.println(product);
    }

    public int maxProduct(TreeNode root) {
        helper(root,totalSum(root));
        ans = ans % 1000000007;
        return (int) ans;
    }

    public int helper(TreeNode root,int sum) {
        if(root ==null) return 0;
        int left = helper(root.left,sum);
        int right = helper(root.right,sum);
        int s = left + right + root.val;
        ans = (long) Math.max(ans,(long)(sum-s)*s);
        return root.val + left +  right;
    }

    public int totalSum(TreeNode root) {
        if(root == null) return 0;
        return root.val + totalSum(root.left) + totalSum(root.right);
    }
}
