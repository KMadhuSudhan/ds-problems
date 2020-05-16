package ds.problems.array;
//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
//1365. How Many Numbers Are Smaller Than the Current Number

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _1365HowManyNumbersAreSmallerThantheCurrentNumber {
    public static void main(String[] args) {
        _1365HowManyNumbersAreSmallerThantheCurrentNumber howManyNumbersAreSmallerThantheCurrentNumber = new _1365HowManyNumbersAreSmallerThantheCurrentNumber();
        int[] nums = {8,1,2,2,3};
        System.out.println(howManyNumbersAreSmallerThantheCurrentNumber.smallerNumbersThanCurrent(nums));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[101];

        for(int num: nums) {
            result[num]++;
        }
        for(int i=1;i<result.length;i++) {
            result[i] = result[i-1]+result[i];
        }
        int index = 0;
        for(int num : nums) {
            if(num != 0)
                nums[index] = result[num-1];
            index++;
        }
        return nums;
    }

    public int[] smallerNumbersThanCurrentPriorityQueue(int[] nums) {

        PriorityQueue<SmallerNumber> priorityQueue = new PriorityQueue<>(new Comparator<SmallerNumber>() {
            @Override
            public int compare(SmallerNumber o1, SmallerNumber o2) {
                return o2.val - o1.val;
            }
        });
        for (int i=0;i<nums.length;i++) {
            SmallerNumber smallerNumber = new SmallerNumber(i,nums[i]);
            priorityQueue.add(smallerNumber);
        }
        int[] ans = new int[nums.length];
        while (!priorityQueue.isEmpty()) {
            SmallerNumber smallerNumber = priorityQueue.poll();
            if(smallerNumber.val == priorityQueue.peek().val) {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(smallerNumber.index);
                while (smallerNumber.val == priorityQueue.peek().val) {
                    SmallerNumber eqSmallerNumber = priorityQueue.poll();
                    indexes.add(eqSmallerNumber.index);
                }
                for (int i : indexes) {
                    ans[i] = priorityQueue.size();
                }
            } else {
                ans[smallerNumber.index] = priorityQueue.size();
            }
        }
        return ans;
    }
    class SmallerNumber {
        int index;
        int val;
        SmallerNumber(int index,int val) {
            this.index = index;
            this.val = val;
        }
    }
}
