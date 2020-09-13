package ds.problems.matrix;

public class _1582SpecialPositionInABinaryMatrix {
    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        if(rows == 0) return 0;
        int cols = mat[0].length;

        int[] rowSum = new int[rows];
        int[] colSum = new int[cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                rowSum[i]+= mat[i][j];
                colSum[j]+= mat[i][j];
            }
        }
        int count = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
