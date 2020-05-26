package ds.problems.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DiskSpace {
    public static void main(String[] args) {
        DiskSpace diskSpace = new DiskSpace();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        System.out.println(diskSpace.segment(1,list));
    }
    public  int segment(int k, List<Integer> space) {
        // Write your code here
        if(k == 0) return 0;
        int length = space.size();
        if(length == 1) return space.get(0);
        List<Integer> result = new ArrayList();
        Deque<Integer> deque = new ArrayDeque<>();
        int i;
        int j =0;
        for(i=0;i<k;i++) {
            while (!deque.isEmpty() && space.get(i) <= space.get(deque.peekLast())){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        for(;i<length;i++) {
            result.add(space.get(deque.peekFirst()));
            while (!deque.isEmpty() &&  deque.peekFirst() <= (i - k) ) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && space.get(i) <= space.get(deque.peekLast())){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        result.add(space.get(deque.peekFirst()));
        int max = Integer.MIN_VALUE;
        for(int disk : result) {
            max = Math.max(max,disk);
        }
        return max;
    }
}
