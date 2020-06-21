package ds.problems.matrix;
//https://leetcode.com/problems/diagonal-traverse/
//498. Diagonal Traverse

public class _498DiagonalTraverse {
    public static void main(String[] args) {
        _498DiagonalTraverse diagonalTraverse = new _498DiagonalTraverse();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[] {};
        int totalCount = matrix.length * matrix[0].length;
        int[] ans = new int[totalCount];
        int count = 0,i=0,j=0;
        ans[count++] = matrix[0][0];
        while(count < totalCount) {
            if(j+1 < matrix[0].length) {
                ans[count++] =  matrix[i][++j];
            } else if(i+1 < matrix.length) {
                ans[count++] =  matrix[++i][j];
            }

            while (i+1<matrix.length && j-1>=0) {
                ans[count++] = matrix[++i][--j];
            }

            if(i+1 < matrix.length) {
                ans[count++] =  matrix[++i][j];
            } else if(j+1 < matrix[0].length) {
                ans[count++] =  matrix[i][++j];
            }

            while (j+1<matrix[0].length && i-1>=0) {
                ans[count++] = matrix[--i][++j];
            }
        }
        return ans;
    }
}
