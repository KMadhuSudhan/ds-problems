package ds.problems.array;
//https://leetcode.com/problems/kth-largest-element-in-an-array/
//215. Kth Largest Element in an Array

public class _215KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        _215KthLargestElementInAnArray kthLargestElementInAnArray = new _215KthLargestElementInAnArray();
        kthLargestElementInAnArray.findKthLargest(nums,0);
        for(int num: nums) {
            System.out.print(" " + num);
        }
    }
    public int findKthLargest(int[] nums, int k) {
        return sort(nums,0,nums.length-1,nums.length - k);

        /*
            //using PriorityQueue
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            for(int i=0;i<nums.length;i++) {
                 pq.offer(nums[i]);
                if(pq.size() > k) {
                    pq.poll();
                }
            }
           return pq.poll();
         */
    }

    int sort(int[] nums,int lo,int hi,int location) {
        while (lo <= hi) { // [lo, hi] is searching space
            int pivot = partition(nums, lo, hi);
            // Numbers to the left of nums[pivot] < nums[pivot]
            // Numbers to the right of nums[pivot] >= nums[pivot]
            if (pivot < location) {
                lo = pivot + 1;
            } else if (pivot > location) {
                hi = pivot - 1;
            } else {
                return nums[pivot];
            }
        }
        return -1;
    }

    int partition(int[] nums,int low,int high) {
        int pivot = high;
        int start = low;
        for (int i=low;i<=high-1;i++) {
            if(nums[i]<= nums[pivot]) {
                swap(nums,i,start);
                start++;
            }
        }
        swap(nums,start,pivot);
        return start;
    }

    void swap(int[] nums,int i,int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
