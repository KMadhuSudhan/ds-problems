package ds.problems.linkedlist;
//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
//430. Flatten a Multilevel Doubly Linked List


import java.util.Stack;

public class _430FlattenMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if(head == null) return null;
        Node tmp = head;
        Stack<Node> stack = new Stack();
        while(tmp!=null) {
            if(tmp.child!=null) {
                if(tmp.next!=null) stack.push(tmp.next);
                tmp.child.prev = tmp;
                tmp.next = tmp.child;
                tmp.child = null;
            } else if(!stack.isEmpty() && tmp.next == null) {
                Node pop = stack.pop();
                pop.prev = tmp;
                tmp.next = pop;
            }
            tmp = tmp.next;
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
