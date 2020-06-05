package ds.problems.trees;
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
//889. Construct Binary Tree from Preorder and Postorder Traversal

public class _889ConstructBinaryTreefromPreorderandPostorderTraversal {
    int preIndex = 0, posIndex = 0;

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] post = {4, 5, 2, 6, 7, 3, 1};
        _889ConstructBinaryTreefromPreorderandPostorderTraversal tree = new _889ConstructBinaryTreefromPreorderandPostorderTraversal();
        tree.constructFromPrePost(pre, post);
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (root.val != post[posIndex])
            root.left = constructFromPrePost(pre, post);
        if (root.val != post[posIndex])
            root.right = constructFromPrePost(pre, post);
        posIndex++;
        return root;
    }

}
