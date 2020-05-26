package ds.problems.matrix;

public class _59SpiralMatrixII {
    public static void main(String[] args) {
        _59SpiralMatrixII spiralMatrixII = new _59SpiralMatrixII();
        spiralMatrixII.generateMatrix(3);
    }
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int rows = n;
        if(rows == 0) return ans;
        int columns = n;
        int last_row = rows - 1;
        int last_column = columns - 1;
        int i, l = 0, k = 0;
        int count = 0;

        while (l <= last_column && k <= last_row) {

            for (i = l; i <= last_column; i++) {
                ans[k][i] = ++count;
            }

            k++;
            for (i = k; i <= last_row; i++) {
                ans[i][last_column] = ++count;
            }

            last_column--;
            if (k <= last_row) {
                for (i = last_column; i >= l; i--) {
                    ans[last_row][i] = ++count;
                }
                last_row--;
            }

            if (l <= last_column) {
                for (i = last_row; i >= k; i--) {
                    ans[i][l] = ++count;
                }
                l++;
            }
        }
        return ans;
    }
}
