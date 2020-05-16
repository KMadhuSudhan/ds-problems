package ds.problems.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();
            while(!stack1.isEmpty() ) {
                TreeNode top = stack1.pop();
                levelResult.add(top.val);
                if(top.left!=null) stack2.push(top.left);
                if(top.right!=null) stack2.push(top.right);
            }
            if(!levelResult.isEmpty()) result.add(levelResult);
            levelResult = new ArrayList<>();
            while(!stack2.isEmpty() ) {
                TreeNode top = stack2.pop();
                levelResult.add(top.val);
                if(top.right!=null) stack1.push(top.right);
                if(top.left!=null) stack1.push(top.left);
            }
            if(!levelResult.isEmpty()) result.add(levelResult);
        }
        return result;
    }
}
