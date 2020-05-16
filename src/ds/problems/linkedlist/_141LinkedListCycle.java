package ds.problems.linkedlist;
//https://leetcode.com/problems/linked-list-cycle/
//141. Linked List Cycle

public class _141LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(slow!=fast &&(fast!=null && fast.next!=null)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == fast;
    }
}
