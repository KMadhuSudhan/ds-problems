package ds.problems.trees;

public class _687LongestUnivaluePath {
    int maxLength = 0;
    public int longestUnivaluePath(TreeNode root) {
        getSubMax(root);
        if(maxLength==0)return 0;
        return maxLength -1;
    }

    public int getSubMax(TreeNode root) {
        if(root==null)return 0;

        int leftMax = getSubMax(root.left);
        int rightMax = getSubMax(root.right);

        int left;
        if(root.left!=null&&root.val==root.left.val){
            left = leftMax+1;
        }
        else{
            left = 1;
        }

        int right;
        if(root.right!=null&&root.val==root.right.val){
            right = rightMax+1;
        }
        else{
            right = 1;
        }
        maxLength = Math.max(maxLength,left+right-1);

        return Math.max(left,right);
    }
}
