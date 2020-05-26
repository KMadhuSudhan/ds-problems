package ds.problems.trees;
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
//106. Construct Binary Tree from Inorder and Postorder Traversal

import java.util.HashMap;
import java.util.Map;

public class _106ConstructBinaryTreefromInorderandPostorderTraversal {
    int postOrderIndex;
    Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
         int[] inorder = {9,3,15,20,7};
         int[] postorder = {9,15,7,20,3};
        _106ConstructBinaryTreefromInorderandPostorderTraversal constructBinaryTreefromInorderandPostorderTraversal = new _106ConstructBinaryTreefromInorderandPostorderTraversal();
        constructBinaryTreefromInorderandPostorderTraversal.buildTree(inorder,postorder);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length-1;
        int idx = 0;
        for(int num: inorder) {
            map.put(num,idx++);
        }
        return  buildTree(inorder,postorder,0,postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder,int start,int end) {
        if(start > end) return null;
        TreeNode root = new TreeNode(postorder[postOrderIndex]);
        int index = map.get(postorder[postOrderIndex]);
        postOrderIndex--;
        root.right = buildTree(inorder,postorder,index+1,end);
        root.left = buildTree(inorder,postorder,start,index-1);
        return root;
    }
}
