package ds.problems.array;
//https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
//462. Minimum Moves to Equal Array Elements II

import java.util.Arrays;

public class _462MinimumMovestoEqualArrayElementsii {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int moves =0;
        int mid = nums.length/2;
        int median = nums[mid]; // we find the median
        for (int i =0; i< nums.length; i++)
        {
            moves += Math.abs(median - nums[i]); // summing up each move
        }
        return moves;
    }
}
