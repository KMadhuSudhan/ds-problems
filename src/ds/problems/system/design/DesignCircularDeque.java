package ds.problems.system.design;
//https://leetcode.com/problems/design-circular-deque/
//641. Design Circular Deque

public class DesignCircularDeque {
    class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    /** Initialize your data structure here. Set the size of the deque to be k. */
    int capacity;
    int size;
    Node head,tail;
    public DesignCircularDeque(int k) {
        capacity = k;
        size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size<capacity) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
            return true;
        }
        return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size < capacity) {
            Node newNode = new Node(value);
            if(tail == null) {
                tail = newNode;
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                tail.prev = newNode;
            }
            size++;
            return true;
        }
        return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(head == null) {
            return false;
        }
        Node tmp = head.next;
        tmp.prev = null;
        head = tmp;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(tail == null) {
            return false;
        }
        Node tmp = tail.prev;
        tmp.next = null;
        tail = tmp;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(head == null) return -1;
        return head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(tail == null) return -1;
        return tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}
