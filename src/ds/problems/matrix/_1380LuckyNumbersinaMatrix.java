package ds.problems.matrix;
//https://leetcode.com/problems/lucky-numbers-in-a-matrix/
//1380. Lucky Numbers in a Matrix

import java.util.*;

public class _1380LuckyNumbersinaMatrix {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {3,7,8},
                {9,11,13},
                {15,16,17}
        };
        _1380LuckyNumbersinaMatrix luckyNumbersinaMatrix = new _1380LuckyNumbersinaMatrix();
        luckyNumbersinaMatrix.luckyNumbers(mat);
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] minRow = new int[matrix.length];
        int[] maxCol = new int[matrix[0].length];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<matrix.length;i++) {
            int min = matrix[i][0];
            for (int j=1;j<matrix[0].length;j++) {
                min = Math.min(min,matrix[i][j]);
            }
            minRow[i] = min;
            map.put(min,min);
        }

        for (int j=0;j<matrix[0].length;j++) {
            int max = matrix[0][j];
            for (int i=1;i<matrix.length;i++) {
                max = Math.max(max,matrix[i][j]);
            }
            maxCol[j] = max;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<maxCol.length;i++){
            if(map.containsKey(maxCol[i])) {
                ans.add(maxCol[i]);
            }
        }
        return ans;
    }
}
