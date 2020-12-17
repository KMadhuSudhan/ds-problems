package ds.problems.trees;

//https://www.lintcode.com/problem/convert-binary-tree-to-doubly-linked-list/description
//
public class BinaryTreeToDoubleLinkedList {
    public class DoublyListNode {
        int val;
        DoublyListNode next, prev;

        DoublyListNode(int val) {
            this.val = val;
            this.next = this.prev = null;
        }
    }

    DoublyListNode head;
    DoublyListNode prev;

    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if (root == null) return null;
        binaryToDoublyList(root);
        return head;
    }

    public void binaryToDoublyList(TreeNode root) {
        // write your code here
        if (root == null) return;
        binaryToDoublyList(root.left);
        DoublyListNode rootNode = new DoublyListNode(root.val);
        if (prev == null) {
            head = rootNode;
        } else {
            rootNode.prev = prev;
            prev.next = rootNode;
        }
        prev = rootNode;
        binaryToDoublyList(root.right);
    }
}
