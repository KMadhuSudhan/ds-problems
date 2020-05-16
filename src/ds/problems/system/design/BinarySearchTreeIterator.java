package ds.problems.system.design;

import ds.problems.trees.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack();
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode x = stack.pop();
        if(x.right!=null) {
            TreeNode node = x.right;
            while(node!=null) {
                stack.push(node);
                node = node.left;
            }
        }
        return x.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
