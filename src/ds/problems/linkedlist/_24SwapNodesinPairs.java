package ds.problems.linkedlist;
//https://leetcode.com/problems/swap-nodes-in-pairs/
//24. Swap Nodes in Pairs

public class _24SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode next = head.next;
        ListNode nextNext = head.next.next;
        next.next = prev;
        prev.next = swapPairs(nextNext);
        return next;
    }
}
