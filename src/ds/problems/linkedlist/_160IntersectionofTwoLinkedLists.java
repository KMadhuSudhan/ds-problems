package ds.problems.linkedlist;
//https://leetcode.com/problems/intersection-of-two-linked-lists
//160. Intersection of Two Linked Lists
public class _160IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n1 = getLength(headA);
        int n2 = getLength(headB);
        if(n1>n2) {
            int diff = n1-n2;
            return getIntersection(headA,headB,diff);
        } else {
            int diff = n2-n1;
            return getIntersection(headB,headA,diff);
        }
    }
    int getLength(ListNode list) {
        ListNode tmp = list;
        int length = 0;
        while(tmp!=null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }
    ListNode getIntersection(ListNode list1,ListNode list2,int diff) {
        ListNode tmp = list1;
        while(diff>0) {
            diff--;
            tmp=tmp.next;
        }
        while(tmp!=list2) {
            tmp = tmp.next;
            list2 = list2.next;
        }
        return tmp;
    }
}
