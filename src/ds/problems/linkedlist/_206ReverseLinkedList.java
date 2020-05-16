package ds.problems.linkedlist;
//https://leetcode.com/problems/reverse-linked-list/
//206. Reverse Linked List

public class _206ReverseLinkedList {

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
