package ds.problems.trees;
//https://leetcode.com/problems/sum-root-to-leaf-numbers/
//129. Sum Root to Leaf Numbers

public class _129SumRootToLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sumNumbers(root,0);
        return sum;
    }

    public void sumNumbers(TreeNode root,int pathSum) {
        if(root == null) {
            return;
        }
        pathSum = pathSum*10 + root.val;
        if(root.left == null && root.right == null) {
            sum+=pathSum;
            pathSum = (pathSum - root.val)/10;
        }
        sumNumbers(root.left,pathSum);
        sumNumbers(root.right,pathSum);
    }
}
