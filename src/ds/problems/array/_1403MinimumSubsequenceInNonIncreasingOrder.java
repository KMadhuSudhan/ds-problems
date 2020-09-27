package ds.problems.array;
//https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
//1403. Minimum Subsequence in Non-Increasing Order

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1403MinimumSubsequenceInNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] arr) {
        List<Integer> ll = new ArrayList<>();
        Arrays.sort(arr);

        int sum = 0, c = 0;
        for(int val:arr) sum += val;

        for(int i=arr.length-1;i>=0;i--) {
            c += arr[i];
            sum -= arr[i];
            ll.add(arr[i]);
            if(c>sum) return ll;
        }
        return ll;
    }
}
