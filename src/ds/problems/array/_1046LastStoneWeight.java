package ds.problems.array;
//https://leetcode.com/problems/last-stone-weight/
//1046. Last Stone Weight

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1046LastStoneWeight {
    public static void main(String[] args) {
        _1046LastStoneWeight lastStoneWeight = new _1046LastStoneWeight();
        int[] nums = {2,7,4,1,8,1};
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int num: stones) {
            pq.offer(num);
        }
        while(pq.size()>1) {
            int first = pq.poll();
            int second = pq.poll();
            if(first == second) continue;
            pq.offer(first - second);
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}
