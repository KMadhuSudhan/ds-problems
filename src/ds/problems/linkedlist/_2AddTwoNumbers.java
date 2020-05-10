package ds.problems.linkedlist;
//https://leetcode.com/problems/add-two-numbers/
//2. Add Two Numbers

public class _2AddTwoNumbers {

    long num = 0;

    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(2);
//        listNode1.next = new ListNode(4);
//        listNode1.next.next = new ListNode(3);
//
//        ListNode listNode2 = new ListNode(5);
//        listNode2.next = new ListNode(6);
//        listNode2.next.next = new ListNode(4);


        ListNode listNode1 = new ListNode(9);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode(9);
        listNode2.next.next.next = new ListNode(9);
        listNode2.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next.next.next.next = new ListNode(9);


        _2AddTwoNumbers addTwoNumbers = new _2AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        System.out.println(result);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = null;
        ListNode listNode = null;
        int carry = 0;
        while (l1!=null || l2!=null) {
            int num1 = l1!=null ? l1.val : 0;
            int num2 = l2!=null ? l2.val : 0;
            int sum = carry + num1 + num2;
            if(head == null) {
                head =  new ListNode(sum %10);
                listNode = head;
            } else {
                listNode.next =  new ListNode( sum%10);
                listNode = listNode.next;
            }
            carry = sum > 9 ? 1 : 0;
            if(l1!=null) {
                l1 = l1.next;
            }
            if(l2!=null) {
                l2 = l2.next;
            }
        }
        if(carry > 0) {
            ListNode node = new ListNode(carry);
            listNode.next = node;
        }
        return head;
    }
}
