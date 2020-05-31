package ds.problems.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class _1171RemoveZeroSumConsecutiveNodesfromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer,ListNode> map =new HashMap<Integer,ListNode>();
        ListNode current =head;
        int sum=0;

        if(head== null) return null;

        while(current!=null){
            sum+=current.val;
            map.put(sum,current);
            current=current.next;
        }

        current = head;
        sum=0;
        while(current!=null){

            sum+=current.val;
            if(sum == 0){
                head = current.next;
            }
            else if(map.containsKey(sum)){

                current.next = map.get(sum).next;
            }
            current=current.next;
        }
        return head;
    }
}
