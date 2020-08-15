package ds.problems.array;

import java.util.PriorityQueue;

public class _164MaximumGap {
    public static void main(String[] args) {
        int[] arr = {3,6,9,1};
        _164MaximumGap maximumGap = new _164MaximumGap();
        maximumGap.maximumGap(arr);
    }
    public int maximumGap(int[] nums) {

        int res = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int i : nums) {
            minHeap.add(i);
        }

        while(minHeap.size() > 1) {
            int last = minHeap.poll();
            int secondLast = minHeap.peek();
            res = Math.max(res, secondLast - last);
        }

        return res;
    }
}
