package ds.problems.linkedlist;

public class _92ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n==m || head == null) return head;
        ListNode startNode = head;
        ListNode startPrev = head;
        int count = 1;
        while(startNode!=null && count < m) {
            startPrev = startNode;
            startNode = startNode.next;
            count++;
        }
        ListNode endNode = startNode;
        while(count < n && endNode!=null) {
            endNode = endNode.next;
            count++;
        }
        ListNode endNext = endNode.next;
        endNode.next = null;
        ListNode reversed =  reverse(startNode);
        startPrev.next = reversed;
        startNode.next = endNext;
        return m==1 ? reversed : head;
    }

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
