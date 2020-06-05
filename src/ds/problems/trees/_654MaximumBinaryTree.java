package ds.problems.trees;
//https://leetcode.com/problems/maximum-binary-tree/
//654. Maximum Binary Tree

public class _654MaximumBinaryTree {
    public static void main(String[] args) {
        _654MaximumBinaryTree maximumBinaryTree = new _654MaximumBinaryTree();
        int[] nums = {3,2,1,6,0,5};
        maximumBinaryTree.constructMaximumBinaryTree(nums);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }

    TreeNode buildTree(int[] nums,int low,int high) {
        if(low > high) return null;
        int index = findIndex(nums,low,high);
        if(index == -1) {
            return null;
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(nums,low,index-1);
        root.right = buildTree(nums,index+1,high);
        return root;
    }

    int findIndex(int[] nums,int low,int high) {
        int max = Integer.MIN_VALUE,index=-1;
        for(int i=low;i<=high;i++) {
            if(max<nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
