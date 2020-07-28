package ds.problems.system.design;
//https://leetcode.com/problems/find-median-from-data-stream/
//295. Find Median from Data Stream

import java.util.PriorityQueue;

public class _295FindMedianFromDataStream {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public _295FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return ((double) (minHeap.peek() + maxHeap.peek())) / 2;
        }

        return (double) maxHeap.peek();
    }
}
