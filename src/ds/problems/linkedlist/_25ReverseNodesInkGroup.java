package ds.problems.linkedlist;
//https://leetcode.com/problems/reverse-nodes-in-k-group/
//25. Reverse Nodes in k-Group

public class _25ReverseNodesInkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next==null) return head;
        int length = findLength(head);
        if(length <k) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = k;
        while(curr!=null && count >0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }
        if(next!=null) {
            head.next = reverseKGroup(next,k);
        }
        return prev;
    }

    int findLength(ListNode head) {
        int length = 0;
        while(head!=null) {
            head = head.next;
            length++;
        }
        return length;
    }
}
