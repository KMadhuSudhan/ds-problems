package ds.problems.slidingwindow;

import java.util.*;

public class _239SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        _239SlidingWindowMaximum slidingWindowMaximum = new _239SlidingWindowMaximum();
        System.out.println(slidingWindowMaximum.maxSlidingWindow(nums,3));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0) return new int[]{};
        int length = nums.length;
        if(length == 1) return new int[]{nums[0]};
        List<Integer> result = new ArrayList();
        Deque<Integer> deque = new ArrayDeque<>();
        int i;
        int j =0;
        for(i=0;i<k;i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        for(;i<length;i++) {
            result.add(nums[deque.peekFirst()]);
            while (!deque.isEmpty() &&  deque.peekFirst() <= (i - k) ) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        result.add(nums[deque.peekFirst()]);
        int listLength = result.size();
        int resultArr[] = new int[listLength];
        for(i=0;i<listLength;i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}
