package ds.problems.array;
//https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
//453. Minimum Moves to Equal Array Elements

public class _453MinimumMovestoEqualArrayElements {
    public int minMoves(int[] nums) {
        int oldsum = 0, smallest=Integer.MAX_VALUE;
        for(int i: nums){
            oldsum += i;
            smallest = Math.min(smallest, i);
        }

        return oldsum - nums.length * smallest;
    }
}
