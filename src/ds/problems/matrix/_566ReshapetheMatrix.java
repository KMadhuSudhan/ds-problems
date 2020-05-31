package ds.problems.matrix;
//https://leetcode.com/problems/reshape-the-matrix/
//566. Reshape the Matrix

public class _566ReshapetheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] ans = new int[r][c];
        int rows = nums.length;
        if(rows == 0) return ans;
        int p=0,q=0,cols = nums[0].length;
        if(rows*cols!=r*c) return nums;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                ans[i][j] = nums[p][q++];
                if(q>=cols) {
                    p++;
                    q=0;
                }
            }
        }
        return ans;
    }
}
