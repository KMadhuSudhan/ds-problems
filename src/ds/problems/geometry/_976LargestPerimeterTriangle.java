package ds.problems.geometry;
//https://leetcode.com/problems/largest-perimeter-triangle/
//976. Largest Perimeter Triangle


import java.util.Arrays;

public class _976LargestPerimeterTriangle {
    public static void main(String[] args) {
        _976LargestPerimeterTriangle largestPerimeterTriangle = new _976LargestPerimeterTriangle();
        int[] nums = {1,2,1};
        System.out.println(largestPerimeterTriangle.largestPerimeter(nums));
    }
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int i=A.length-1;i >=2;i--) {
            int side1 = A[i];
            for(int j=i-1;j>=1;j--) {
                int side2 = A[j];
                int side3 = A[j-1];
                if((side2 + side3) > side1) {
                    return side1 + side2 + side3;
                }
            }
        }
        return 0;
    }
}
