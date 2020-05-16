package ds.problems.linkedlist;
//https://leetcode.com/problems/remove-linked-list-elements/
//203. Remove Linked List Elements

public class _203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        while(head!=null && head.val == val) {
            head = head.next;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null) {
            prev = curr;
            curr = curr.next;
            while(curr!=null && curr.val == val) {
                curr = curr.next;
            }
            prev.next = curr;
        }
        return head;
    }
}
