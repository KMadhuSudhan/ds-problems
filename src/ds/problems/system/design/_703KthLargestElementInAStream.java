package ds.problems.system.design;
//https://leetcode.com/problems/kth-largest-element-in-a-stream/
//703. Kth Largest Element in a Stream

import java.util.PriorityQueue;

public class _703KthLargestElementInAStream {

    PriorityQueue<Integer> pq;
    int k;
    public _703KthLargestElementInAStream(int k, int[] nums) {
        this.pq = new PriorityQueue();
        this.k = k;
        for(int i=0;i<nums.length;i++) {
            pq.offer(nums[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        if(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
