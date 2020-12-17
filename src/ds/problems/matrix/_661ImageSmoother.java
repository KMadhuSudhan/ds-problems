package ds.problems.matrix;
//https://leetcode.com/problems/image-smoother/
//661. Image Smoother

public class _661ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int rows = M.length;
        int cols = M[0].length;
        int[][] ans = new int[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                ans[i][j] = getValue(i, j, M);
            }
        }
        return ans;
    }
    private int getValue(int i, int j, int[][] M) {

        int numerator = 0;
        int denominator = 0;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {

                int newX = i + x;
                int newY = j + y;

                if (!isOutOfBounds(newX, newY, M)) {
                    denominator++;
                    numerator += M[newX][newY];
                }
            }
        }

        return (int) numerator/ denominator;

    }

    private boolean isOutOfBounds(int x, int y, int[][] M) {
        return (x < 0 || x >= M.length || y < 0 || y >= M[x].length);
    }
}
