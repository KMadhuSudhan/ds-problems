package ds.problems.system.design;
//https://leetcode.com/problems/linked-list-random-node/
//382. Linked List Random Node

import ds.problems.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _382LinkedListRandomNode {

    List<Integer> list;
    Random ran;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public _382LinkedListRandomNode(ListNode head) {
        ListNode tmp = head;
        list = new ArrayList();
        ran = new Random();
        while(tmp!=null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        return list.get(ran.nextInt(list.size()));
    }
}
