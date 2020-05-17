package ds.problems.trees;
//https://leetcode.com/problems/squares-of-a-sorted-array/
//977. Squares of a Sorted Array

public class _977SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        _977SquaresOfASortedArray squaresOfASortedArray = new _977SquaresOfASortedArray();
        squaresOfASortedArray.sortedSquares(nums);
    }
    public int[] sortedSquares(int[] A) {
        int low=0,high=A.length-1;
        int[] squares = new int[A.length];
        int count = A.length-1;
        while(low<=high) {
            int lSq = A[low] * A[low];
            int hSq = A[high] * A[high];
            if(hSq>lSq) {
                squares[count--] = hSq;
                high--;
            } else {
                squares[count--] = lSq;
                low++;
            }
        }
        return squares;
    }
}
