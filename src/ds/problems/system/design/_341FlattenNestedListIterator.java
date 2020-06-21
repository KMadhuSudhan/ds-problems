package ds.problems.system.design;
//https://leetcode.com/problems/flatten-nested-list-iterator/
//341. Flatten Nested List Iterator

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _341FlattenNestedListIterator {

    Queue<Integer> queue = new LinkedList();

    public _341FlattenNestedListIterator(List<NestedInteger> nestedList) {
        parse(nestedList);
    }

    public Integer next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    void parse(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return;
        }
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                queue.add(nestedInteger.getInteger());
            } else {
                parse(nestedInteger.getList());
            }
        }
    }

    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }
}
