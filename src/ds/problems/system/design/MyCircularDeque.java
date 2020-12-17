package ds.problems.system.design;
//https://leetcode.com/problems/design-circular-deque/discuss/729512/java-array-base
//https://leetcode.com/problems/design-circular-deque/
//641. Design Circular Deque

public class MyCircularDeque {
    int[] data;
    int size;
    int start;  // first element position

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(1);
        myCircularDeque.insertLast(2);			// return true
        myCircularDeque.insertFront(3);			// return true
        myCircularDeque.insertFront(4);
    }
    // last element position
    private int getLast() {
        return (start + size - 1) % data.length;
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        data = new int[k];
        size = 0;
        start = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        start = (start - 1 + data.length) % data.length;
        data[start] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        int last = getLast();
        last = (last + 1) % data.length;
        data[last] = value;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        start = (start + 1) % data.length;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return data[start];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return data[getLast()];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == data.length;
    }
}
