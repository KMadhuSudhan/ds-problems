package ds.problems.matrix;
//https://leetcode.com/problems/sort-the-matrix-diagonally/
//1329. Sort the Matrix Diagonally

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1329SorttheMatrixDiagonally {

    public static void main(String[] args) {
        int[][] mat = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        };
        _1329SorttheMatrixDiagonally sorttheMatrixDiagonally = new _1329SorttheMatrixDiagonally();
        sorttheMatrixDiagonally.diagonalSort(mat);
    }

    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        if(rows == 0) return mat;
        int cols = mat[0].length;
        int row =0;
        while (row<rows) {
            int r=row;
            int c=0;
            List<Integer> list = new ArrayList<>();
            while (r < rows && c < cols) {
                list.add(mat[r++][c++]);
            }

            Collections.sort(list);

            r=row;
            c=0;
            int k=0;
            while (r < rows && c < cols) {
                mat[r++][c++] = list.get(k++);
            }
            row++;
        }

        int col=1;
        while (col<cols) {
            int r=0;
            int c=col;
            List<Integer> list = new ArrayList<>();
            while (r < rows && c < cols) {
                list.add(mat[r++][c++]);
            }

            Collections.sort(list);

            r=0;
            c=col;
            int k=0;
            while (r < rows && c < cols) {
                mat[r++][c++] = list.get(k++);
            }
            col++;
        }
        return mat;
    }
}
