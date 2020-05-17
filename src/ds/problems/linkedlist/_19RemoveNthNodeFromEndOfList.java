package ds.problems.linkedlist;
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
//19. Remove Nth Node From End of List

public class _19RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        ListNode tmp1 = head;
        ListNode prev = head;
        while(n>0) {
            tmp = tmp.next;
            n--;
        }
        if(tmp == null) {
            return head.next;
        }
        while(tmp!=null) {
            prev = tmp1;
            tmp = tmp.next;
            tmp1 = tmp1.next;
        }

        prev.next = tmp1.next;
        return head;
    }
}
