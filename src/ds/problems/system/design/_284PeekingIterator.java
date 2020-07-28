package ds.problems.system.design;
//https://leetcode.com/problems/peeking-iterator/
//284. Peeking Iterator

import java.util.Iterator;

public class _284PeekingIterator {

    private Iterator<Integer> itr;
    private Integer nextVal;

    public _284PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.itr = iterator;
        if(itr.hasNext()) {
            nextVal = itr.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextVal;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    public Integer next() {
        Integer result = nextVal;
        if(itr.hasNext()) {
            nextVal = itr.next();
        } else {
            nextVal = null;
        }
        return result;
    }

    public boolean hasNext() {
        return nextVal!=null;
    }
}
