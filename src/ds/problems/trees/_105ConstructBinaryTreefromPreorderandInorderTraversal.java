package ds.problems.trees;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//105. Construct Binary Tree from Preorder and Inorder Traversal

public class _105ConstructBinaryTreefromPreorderandInorderTraversal {

    int preOrderIndex;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;
        int idx = 0;
        for(int num: inorder) {
            map.put(num,idx++);
        }
        return  buildTree(preorder,inorder,0,preorder.length-1);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder,int start,int end) {
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[preOrderIndex]);
        int index = map.get(preorder[preOrderIndex]);
        preOrderIndex++;
        root.left = buildTree(preorder,inorder,start,index-1);
        root.right = buildTree(preorder,inorder,index+1,end);
        return root;
    }
}
