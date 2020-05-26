package ds.problems.array;
//https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference
///1218. Longest Arithmetic Subsequence of Given Difference


import java.util.HashMap;
import java.util.Map;

public class _1218LongestArithmeticSubsequenceofGivenDifference {

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int x : arr) {
            int diff = x-difference;
            int freq = map.getOrDefault(diff, 0) + 1;
            map.put(x, freq);
            max = Math.max(max,freq);
        }
        return max;
    }
}
