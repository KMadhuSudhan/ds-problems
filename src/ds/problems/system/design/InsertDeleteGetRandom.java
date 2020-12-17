package ds.problems.system.design;
//https://leetcode.com/problems/insert-delete-getrandom-o1/
//380. Insert Delete GetRandom O(1)

import java.util.*;

public class InsertDeleteGetRandom {
    Set<Integer> set;
    List<Integer> list;
    int idx;
    Random random;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        set = new HashSet();
        list = new ArrayList();
        random = new Random();
        idx = -1;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean added = set.add(val);
        if(added) {
            list.add(val);
            calNextIndex();
        }
        return added;
    }

    void calNextIndex() {
        if(list.size()!=0) {
            idx = random.nextInt(list.size());
        } else {
            idx = -1;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean removed = set.remove(val);
        if(removed) {
            list.remove(list.indexOf(val));
            calNextIndex();
        }
        return removed;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int val = -1;
        if(idx != -1){
            val = list.get(idx);
            calNextIndex();
        }
        return val;
    }
}
