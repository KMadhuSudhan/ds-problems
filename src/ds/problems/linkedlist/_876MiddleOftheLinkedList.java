package ds.problems.linkedlist;
//https://leetcode.com/problems/middle-of-the-linked-list/
//876. Middle of the Linked List

public class _876MiddleOftheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
