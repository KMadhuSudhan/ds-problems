package ds.problems.matrix;
//https://leetcode.com/problems/search-a-2d-matrix/
//74. Search a 2D Matrix

public class _74SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0) return false;
        int cols = matrix[0].length;
        if(cols == 0) return false;
        for(int i=0;i<rows;i++) {
            if(matrix[i][cols-1] == target) return true;
            if(matrix[i][cols-1] > target) {
                return binarySearch(matrix[i],target);
            }
        }
        return false;
    }

    boolean binarySearch(int[] num,int target) {
        int low = 0,high = num.length-1;
        while(low<=high) {
            int mid = low + (high - low)/2;
            if(num[mid] == target) return true;
            if(num[mid]> target) {
                high = mid -1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }

}
