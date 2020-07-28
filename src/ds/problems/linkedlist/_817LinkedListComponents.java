package ds.problems.linkedlist;
//https://leetcode.com/problems/linked-list-components/
//817. Linked List Components

import java.util.HashSet;

public class _817LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        int count = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int g : G)
            set.add(g);

        while (head != null) {
            if (set.contains(head.val)) {
                ListNode partner = head.next;
                if (partner == null || !set.contains(partner.val))
                    count++;
            }
            head = head.next;
        }
        return count;
    }
}
