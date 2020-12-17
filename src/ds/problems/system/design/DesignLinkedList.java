package ds.problems.system.design;
//https://leetcode.com/problems/design-linked-list/
//707. Design Linked List

public class DesignLinkedList {
    class Node {
        Node next;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
    Node head;
    Node tail;
    int size = 0;
    /** Initialize your data structure here. */
    public DesignLinkedList() {
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index > size -1) return -1;
        int count = 0;
        Node tmp = head;
        while(count<index) {
            tmp = tmp.next;
            count++;
        }
        return tmp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index == 0) {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        int count = 0;
        Node tmp = head;
        Node prev = head;
        while(count<index && tmp!=null) {
            prev = tmp;
            tmp = tmp.next;
            count++;
        }
        if(tmp == null) {
            Node newNode = new Node(val);
            tail.next = newNode;
            tail = newNode;
            size++;
            return;
        }
        Node newNode = new Node(val);
        prev.next = newNode;
        newNode.next = tmp;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index > size - 1) return;
        if(index == 0) {
            head = head.next;
            size--;
            return;
        }
        int count = 0;
        Node tmp = head;
        Node prev = head;
        while(count<index) {
            prev = tmp;
            tmp = tmp.next;
            count++;
        }
        prev.next = tmp.next;
        if(tmp.next == null) {
            tail = prev;
        }
        size--;
    }
}
