package ds.problems.array;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/wiggle-sort-ii/
//324. Wiggle Sort II
public class _324WiggleSortII {
    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        _324WiggleSortII wiggleSortII = new _324WiggleSortII();
        wiggleSortII.wiggleSort(nums);
    }
    public void wiggleSort(int[] nums) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int num: nums) {
//            pq.offer(num);
//        }
//
//        for (int i = 1; i < nums.length; i= i + 2) {
//            nums[i] = pq.poll();
//        }
//
//        for (int i = 0; i < nums.length; i= i + 2) {
//            nums[i] = pq.poll();
//        }

        int n = nums.length, m = (n + 1) >> 1;
        if (n <= 1) return;
        int[] aux = nums.clone();
        Arrays.sort(aux);
        for (int i = 0, j = m - 1; j >= 0; i += 2, j --) nums[i] = aux[j];
        for (int i = 1, j = n - 1; j >= m; i += 2, j --) nums[i] = aux[j];
    }
    void swap(int[] nums,int i,int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
