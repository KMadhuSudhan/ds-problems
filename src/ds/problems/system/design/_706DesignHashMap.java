package ds.problems.system.design;
//https://leetcode.com/problems/design-hashmap/
//706. Design HashMap

public class _706DesignHashMap {
    class Node {
        int val;
        int key;
        Node next;
        public Node(int key,int value) {
            this.key = key;
            this.val = value;
        }
    }
    private static final int SIZE = 500;
    Node[] holder;

    /** Initialize your data structure here. */
    public _706DesignHashMap() {
        holder = new Node[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hash(key);
        Node node = new Node(key, value);
        boolean exists = false;
        if (holder[hash] == null) {
            holder[hash] = node;
        } else {
            Node current = holder[hash];
            Node root = current;
            while(current != null) {
                if (current.key == key) {
                    current.val = value;
                    exists = true;
                    break;
                }
                current = current.next;
            }
            if (!exists) {
                node.next = root;
                holder[hash] = node;
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(key);
        if(holder[hash] == null) {
            return -1;
        } else {
            Node root = holder[hash];
            Node current = root;
            while(current!=null) {
                if(current.key == key) {
                    return current.val;
                }
                current = current.next;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key);
        Node current = holder[hash];
        Node root = current;
        if(current == null) return;
        if (current.key == key) {
            holder[hash] = current.next;
        } else {
            while (current.next != null) {
                Node temp = current.next;
                if (temp != null && temp.key == key) {
                    current.next = temp.next;
                    break;
                }
                current = current.next;
            }
            holder[hash] = root;
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

}
