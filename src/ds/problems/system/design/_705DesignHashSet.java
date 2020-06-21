package ds.problems.system.design;
//https://leetcode.com/problems/design-hashset/
//705. Design HashSet

import java.util.ArrayList;

public class _705DesignHashSet {

    ArrayList<Integer>[] list;
    /** Initialize your data structure here. */
    public _705DesignHashSet() {
        list = new ArrayList[1000];
    }

    public void add(int key) {
        int hash = hash(key);
        if(list[hash] == null) {
            list[hash] = new ArrayList();
        }
        if(!list[hash].contains(key)) {
            list[hash].add(key);
        }
    }

    public void remove(int key) {
        Integer hash = hash(key);
        if(list[hash] == null) return;
        if(list[hash].contains(key)) {
            list[hash].remove(list[hash].indexOf(key));
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        Integer hash = hash(key);
        if(list[hash] == null) {
            return false;
        } else {
            return list[hash].contains(key);
        }
    }

    private Integer hash(int key) {
        return key%1000;
    }
}
