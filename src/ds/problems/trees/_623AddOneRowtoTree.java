package ds.problems.trees;
//https://leetcode.com/problems/add-one-row-to-tree/
//623. Add One Row to Tree

public class _623AddOneRowtoTree {
    boolean leftDone = false;
    boolean rightDone = false;
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode newNode = new TreeNode(v);
            newNode.left = root;
            return newNode;
        } else {
            dfs(root,v,d,1);
        }
        return root;
    }

    void dfs(TreeNode root,int v, int d, int level) {
        if(root == null) {
            return;
        }
        if(level == d-1) {
            if(root.left!=null) {
                TreeNode oldleft = root.left;
                TreeNode newLeft = new TreeNode(v);
                root.left = newLeft;
                newLeft.left = oldleft;
                leftDone = true;
            }
            else {
                root.left = new TreeNode(v);
                leftDone = true;
            }

            if(root.right!=null) {
                TreeNode oldRight = root.right;
                TreeNode newRight = new TreeNode(v);
                root.right = newRight;
                newRight.right = oldRight;
                rightDone = true;
            }
            else {
                root.right = new TreeNode(v);
                rightDone = true;
            }

        } else {
            dfs(root.left,v,d,level+1);
            dfs(root.right,v,d,level+1);
        }
    }
}
