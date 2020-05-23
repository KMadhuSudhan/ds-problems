package ds.problems.trees;

public class _108ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBST(nums,0,nums.length-1);
    }

    public TreeNode arrayToBST(int[] nums,int low,int high) {
        if(low>high) return null;
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrayToBST(nums,low,mid-1);
        root.right = arrayToBST(nums,mid+1,high);
        return root;
    }
}
