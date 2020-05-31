package ds.problems.linkedlist;
//https://leetcode.com/problems/rotate-list/
//61. Rotate List

public class _61RotateList {
    public static void main(String[] args) {
        ListNode linkedList = new ListNode(1);
        linkedList.next = new ListNode(2);
        _61RotateList rotateList = new _61RotateList();
        rotateList.rotateRight(linkedList,1);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int length = 0;
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
            length++;
        }
        length++;

        if (k % length == 0) return head;
        k = k % length;

        int count = 1;
        ListNode temp = head;
        while ((length - count) != k) {
            temp = temp.next;
            count++;
        }
        end.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }
}
