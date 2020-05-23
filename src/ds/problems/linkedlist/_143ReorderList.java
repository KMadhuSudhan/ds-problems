package ds.problems.linkedlist;
//https://leetcode.com/problems/reorder-list/
//143. Reorder List

import java.util.ArrayList;
import java.util.List;

public class _143ReorderList {

    public void reorderList(ListNode head) {
        if(head == null) return;
        List<ListNode> nodes = getNodes(head);
        int low = 0,high = nodes.size() -1;
        while(low<high) {
            nodes.get(low).next = nodes.get(high);
            nodes.get(high).next = nodes.get(low+1);
            low++;
            high--;
        }
        nodes.get(low).next = null;
    }

    List<ListNode> getNodes(ListNode head) {
        List<ListNode> list = new ArrayList();
        ListNode tmp = head;
        while(tmp!=null) {
            list.add(tmp);
            tmp = tmp.next;
        }
        return list;
    }
}
