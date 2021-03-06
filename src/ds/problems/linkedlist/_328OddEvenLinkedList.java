package ds.problems.linkedlist;
//https://leetcode.com/problems/odd-even-linked-list/
//
public class _328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode temp = head;
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        if (count <= 1) return head;
        ListNode prev = head;
        ListNode nextNext = head.next.next;
        ListNode lastNode = temp;
        while (!nextNext.equals(lastNode) && !nextNext.next.equals(lastNode)) {
            temp.next = prev.next;
            temp = prev.next;
            prev.next = nextNext;
            prev = nextNext;
            nextNext = nextNext.next.next;
        }

        temp.next = prev.next;
        temp = prev.next;
        prev.next = nextNext;
        if (count % 2 == 1) {
            prev.next.next = nextNext.next.next;
            temp.next = lastNode;
            lastNode.next = null;
        } else {
            temp.next = null;
        }

        return head;
    }
}
