package ds.problems.linkedlist;
//https://leetcode.com/problems/partition-list/
//86. Partition List

public class _86PartitionList {
    public ListNode partition(ListNode head, int x) {
        //Segregate elements < x in myLL
        ListNode dummy=new ListNode(0);         //my LL
        ListNode head2=dummy;

        //same as REMOVE LinkedList elements
        ListNode dummy1=new ListNode(0);         //given LL
        dummy1.next=head;
        ListNode curr=dummy1;
        while(curr!=null){
            while(curr.next!=null && curr.next.val<x ){
                dummy.next=curr.next;                 // add to myLL
                dummy=dummy.next;
                curr.next=curr.next.next;             //removing from given list
            }
            curr=curr.next;
        }
        //no need to find tail as dummy ptr will be at last node of myLL
        dummy.next=dummy1.next;
        return head2.next;
    }
}
