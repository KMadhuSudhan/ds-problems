package ds.problems.linkedlist;
//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
//82. Remove Duplicates from Sorted List II

public class _82RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        boolean headDuplicated = false;
        while(head!=null && head.next!=null && head.val == head.next.val) {
            head = head.next;
            headDuplicated = true;
        }
        head = headDuplicated ? deleteDuplicates(head.next) : head;
        ListNode tmp = head;
        ListNode prev = head;
        while(tmp!=null) {
            ListNode tmp1 = tmp;
            while(tmp1!=null && tmp1.next!=null && tmp1.val == tmp1.next.val) {
                tmp1 = tmp1.next;
            }
            if(tmp == tmp1) {
                prev = tmp;
                tmp = tmp.next;
            }
            else if(tmp1!=null) {
                prev.next = tmp1.next;
                tmp = tmp1.next;
            }
        }
        return head;
    }
}
