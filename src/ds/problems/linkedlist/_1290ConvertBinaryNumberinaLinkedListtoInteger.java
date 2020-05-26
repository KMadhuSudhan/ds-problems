package ds.problems.linkedlist;
//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/submissions/
//1290. Convert Binary Number in a Linked List to Integer

public class _1290ConvertBinaryNumberinaLinkedListtoInteger {
    int base=1,num=0;
    public int getDecimalValue(ListNode head) {
        if(head == null) return 0;
        getDecimalValue(head.next);
        num+=head.val*base;
        base*=2;
        return num;
    }
}
