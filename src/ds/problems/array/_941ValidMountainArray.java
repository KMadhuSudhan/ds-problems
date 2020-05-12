package ds.problems.array;
//https://leetcode.com/problems/valid-mountain-array/
//941. Valid Mountain Array

public class _941ValidMountainArray {
    public static void main(String[] args) {
        _941ValidMountainArray validMountainArray = new _941ValidMountainArray();
        int[] nums = {14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3};
        System.out.println(validMountainArray.validMountainArray(nums));
    }

    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;
        while (i+1 < N && A[i] < A[i+1])
            i++;
        if(i==A.length-1 || i == 0) return false;
        while (i+1 < N && A[i] > A[i+1])
            i++;
        return i==N-1;
    }
}
