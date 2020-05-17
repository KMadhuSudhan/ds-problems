package ds.problems.sortings;
//https://leetcode.com/problems/insertion-sort-list/
//147. Insertion Sort List

import ds.problems.linkedlist.ListNode;

public class _147InsertionSortList {

    ListNode result = null;
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode tmp=head;
        result = new ListNode(head.val);
        tmp = tmp.next;
        while(tmp!=null) {
            insertionSort(tmp);
            tmp = tmp.next;
        }
        return result;
    }

    void insertionSort(ListNode newNode) {
        if(newNode.val <= result.val) {
            ListNode node = new ListNode(newNode.val);
            node.next = result;
            result = node;
        } else {
            ListNode tmp =  result;
            ListNode prev = result;
            while(tmp!=null && tmp.val < newNode.val) {
                prev = tmp;
                tmp = tmp.next;
            }
            ListNode node = new ListNode(newNode.val);
            prev.next = node;
            node.next = tmp;
        }
    }
}
