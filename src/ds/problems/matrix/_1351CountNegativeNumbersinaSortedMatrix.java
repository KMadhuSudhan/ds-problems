package ds.problems.matrix;
//https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
//1351. Count Negative Numbers in a Sorted Matrix

public class _1351CountNegativeNumbersinaSortedMatrix {
    public int countNegatives(int[][] grid) {
        if(grid.length ==0) return 0;
        int count = 0,i = 0,j = grid[0].length-1;
        while(i<grid.length && j>=0) {
            if(grid[i][j]<0) {
                count+=grid.length -i;
                j--;
            }  else {
                i++;
            }
        }
        return count;
    }
}
