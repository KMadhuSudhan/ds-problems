package ds.problems.array;
//https://leetcode.com/problems/summary-ranges/
//228. Summary Ranges

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _228SummaryRanges {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(-2);
        priorityQueue.add(4);
        System.out.println(priorityQueue.poll());
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList();


        if(nums.length == 0 ) return list;
        int start = nums[0];
        for(int i=1;i<nums.length;i++) {
            if(nums[i]!=nums[i-1]+1) {
                if(start == nums[i-1]) {
                    list.add("" + start);
                } else {
                    list.add("" + start + "->" + nums[i-1]);
                }
                start = nums[i];
            }
        }
        if(start == nums[nums.length-1]) {
            list.add("" + start);
        } else {
            list.add("" + start + "->" + nums[nums.length-1]);
        }
        return list;
    }
}
