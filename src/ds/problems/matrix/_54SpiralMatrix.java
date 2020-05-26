package ds.problems.matrix;
//https://leetcode.com/problems/spiral-matrix/
//54. Spiral Matrix

import java.util.ArrayList;
import java.util.List;

public class _54SpiralMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };
        _54SpiralMatrix spiralMatrix = new _54SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0) return list;
        int k=0,l=matrix[0].length-1,m=matrix.length-1;
        while (k<=m) {

            //row
            for (int i=k;i<=l;i++) {
                list.add(matrix[k][i]);
            }

            //column
            for (int i=k+1;i<=m;i++) {
                list.add(matrix[i][l]);
            }

            l--;

            //reverse row
            for (int i=l;i>=k;i--) {
                list.add(matrix[m][i]);
            }
            m--;
            //reverse column
            for (int i=m;i>k;i--) {
                list.add(matrix[i][k]);
            }
            k++;

        }
        return list;
    }
}
