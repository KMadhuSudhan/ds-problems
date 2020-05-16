package ds.problems.linkedlist;
//https://leetcode.com/problems/next-greater-node-in-linked-list/
//1019. Next Greater Node In Linked List

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _1019NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNode head) {
        if(head == null) return new int[]{};
        if(head.next == null) return new int[]{0};
        ListNode tmp = head;
        List<Integer> list = new ArrayList();
        while(tmp!=null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        int[] result = new int[list.size()];
        Stack<Integer> stack = new Stack();
        for(int i=0;i<list.size();i++) {
            while(!stack.isEmpty() &&  list.get(stack.peek()) < list.get(i)) {
                result[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        result[list.size()-1] = 0;
        return result;
    }
}
