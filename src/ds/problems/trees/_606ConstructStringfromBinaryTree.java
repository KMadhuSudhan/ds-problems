package ds.problems.trees;
//https://leetcode.com/problems/construct-string-from-binary-tree/
//606. Construct String from Binary Tree

public class _606ConstructStringfromBinaryTree {

    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        buildString(t);
        return sb.toString();
    }

    public void buildString(TreeNode root) {
        if(root == null) return;
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            return;
        }
        sb.append('(');
        buildString(root.left);
        sb.append(')');
        if(root.right!=null) {
            sb.append('(');
            buildString(root.right);
            sb.append(')');
        }
    }
}
