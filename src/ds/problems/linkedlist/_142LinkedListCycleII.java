package ds.problems.linkedlist;
//https://leetcode.com/problems/linked-list-cycle-ii/
//142. Linked List Cycle II

public class _142LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                flag = true;
                break;
            }
        }
        if(fast == null || fast.next == null) return null;
        fast = head;
        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
