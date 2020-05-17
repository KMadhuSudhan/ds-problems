package ds.problems.linkedlist;
//https://leetcode.com/problems/add-two-numbers-ii/
//445. Add Two Numbers II

import java.util.ArrayList;
import java.util.List;

public class _445AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l1;
        if(l2 == null) return l2;
        List<Integer> list1 = getList(l1);
        List<Integer> list2 = getList(l2);
        int i = list1.size() - 1,j = list2.size() -1,carry=0;
        ListNode temp = null;
        while(i>=0 && j>=0) {
            int sum = carry + list1.get(i) + list2.get(j);
            if(temp == null) {
                temp = new ListNode(sum%10);
            } else {
                ListNode node =  new ListNode(sum%10);
                node.next = temp;
                temp = node;
            }
            carry = sum > 9 ? 1:0;
            i--;
            j--;
        }

        while(i>=0) {
            int sum = carry + list1.get(i);
            ListNode node =  new ListNode(sum%10);
            node.next = temp;
            temp = node;
            carry = sum > 9 ? 1:0;
            i--;
        }

        while(j>=0) {
            int sum = carry + list2.get(j);
            ListNode node =  new ListNode(sum%10);
            node.next = temp;
            temp = node;
            carry = sum > 9 ? 1:0;
            j--;
        }
        if(carry > 0) {
            ListNode node =  new ListNode(carry);
            node.next = temp;
            temp = node;
        }
        return temp;
    }

    public List<Integer> getList(ListNode node) {
        List<Integer> list = new ArrayList();
        while(node!=null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }
}
