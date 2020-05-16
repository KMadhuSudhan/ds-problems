package ds.problems.sortings;
//https://leetcode.com/problems/merge-k-sorted-lists/
//23. Merge k Sorted Lists

import ds.problems.linkedlist.ListNode;

import java.util.PriorityQueue;

public class _23MergeKsorted {

    public static void main(String[] args) {

    }

    public ListNode mergeKListst(ListNode[] lists) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<lists.length;i++) {
            ListNode list = lists[i];
            while (list!=null) {
                priorityQueue.add(list.val);
            }
        }
        ListNode head = new ListNode(priorityQueue.poll());
        ListNode tmp = head;
        while (!priorityQueue.isEmpty()) {
                tmp.next = new ListNode(priorityQueue.poll());
                tmp = tmp.next;
        }
        return head;
    }


    public ListNode mergeKListsFivePercent(ListNode[] lists) {
        ListNode result = lists[0];
        for(int i=1;i<lists.length;i++) {
            result  = mergeKLists(result,lists[1]);
        }
        return result;
    }


    public ListNode mergeKLists(ListNode list1,ListNode list2) {
        ListNode result = null;
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        if(list1.val<= list2.val) {
            result = list1;
            result.next = mergeKLists(list1.next,list2);
        } else {
            result = list2;
            result.next = mergeKLists(list1,list2.next);
        }
        return result;
    }
}
