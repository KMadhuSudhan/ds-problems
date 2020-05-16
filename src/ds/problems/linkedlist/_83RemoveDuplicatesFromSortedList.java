package ds.problems.linkedlist;
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
//83. Remove Duplicates from Sorted List

public class _83RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        while(head!=null && head.next!=null && head.val == head.next.val) {
            head = head.next;
        }
        ListNode tmp = head;
        while(tmp!=null) {
            ListNode tmp1 = tmp;
            while(tmp1!=null && tmp1.next!=null && tmp1.val == tmp1.next.val) {
                tmp1 = tmp1.next;
            }
            if(tmp == tmp1) {
                tmp = tmp.next;
            }
            else if(tmp1!=null) {
                tmp.next = tmp1.next;
                tmp = tmp1;
            }
        }
        return head;
    }
}
