package ds.problems.array;
//https://leetcode.com/problems/global-and-local-inversions/
//775. Global and Local Inversions

public class _775GlobalandLocalInversions {

    public boolean isIdealPermutation(int[] A) {
        int global = 0,local=0;
        for (int i = 0; i < A.length; i++)
            if (Math.abs(A[i] - i) > 1)
                return false;
        return true;
    }
}
