package ds.problems.linkedlist;

public class _237DeleteNodeInaLinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
