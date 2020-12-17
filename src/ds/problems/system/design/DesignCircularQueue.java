package ds.problems.system.design;
//https://leetcode.com/problems/design-circular-queue/
//622. Design Circular Queue

public class DesignCircularQueue {
    int[] circularQueue;
    int s;
    int e;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public DesignCircularQueue(int k) {
        circularQueue = new int[k];
        s = 0;
        e = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(e - s == circularQueue.length) return false;
        circularQueue[e%circularQueue.length] = value;
        e++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (e == s) return false;
        s++;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (e == s) return -1;
        return circularQueue[s%circularQueue.length];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (e == s) return -1;
        return circularQueue[(e-1)%circularQueue.length];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return s == e;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return e - s == circularQueue.length;
    }
}
