package ds.problems.trees;
//https://www.lintcode.com/problem/convert-binary-search-tree-to-sorted-doubly-linked-list/description
//
public class BstToDoublyList {
    TreeNode head = null;
    TreeNode prev = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        // Write your code here.
        if (root == null) return null;
        binaryToDoublyList(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    public void binaryToDoublyList(TreeNode root) {
        // write your code here
        if (root == null) return;
        binaryToDoublyList(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        binaryToDoublyList(root.right);
    }
}
