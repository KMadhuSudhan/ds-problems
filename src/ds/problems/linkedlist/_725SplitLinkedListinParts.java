package ds.problems.linkedlist;
//https://leetcode.com/problems/split-linked-list-in-parts/

public class _725SplitLinkedListinParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        if(k==0) return null;
        int length = findLength(root);
        int equalSize = length/k == 0 ? 1 : length/k;
        int differSize = length - equalSize*k;
        ListNode[] list = new ListNode[k];
        ListNode head = root,next = root,prev = next;;
        int start = 0,i=0;
        while(next!=null) {
            while(start<equalSize && next!=null)   {
                prev = next;
                next = next.next;
                start++;
            }
            if(differSize>0) {
                prev = next;
                next = next.next;
                differSize--;
            }
            ListNode temp = next;
            prev.next = null;
            list[i++] = head;
            next = temp;
            head = temp;
            prev = temp;
            start = 0;
        }
        return list;
    }
    int findLength(ListNode root) {
        ListNode tmp = root;
        int length = 0;
        while(tmp!=null) {
            tmp = tmp.next;
            length++;
        }
        return length;
    }
}
