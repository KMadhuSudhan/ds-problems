package ds.problems.array;
//https://leetcode.com/problems/previous-permutation-with-one-swap/
//1053. Previous Permutation With One Swap

public class _1053PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] A) {
        int n = A.length;

        int index = -1;

        int min = A[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            if(A[i] > min) {
                index = i;
                break;
            }

            min = Math.min(min, A[i]);
        }

        if(index == -1)
            return A;

        int swap = 0;
        int max = Integer.MIN_VALUE;
        for(int i = index + 1; i < n; i++) {
            if(A[i] < A[index] && A[i] > max) {
                swap = i;
                max = A[i];
            }
        }

        int tmp = A[index];
        A[index] = A[swap];
        A[swap] = tmp;

        return A;
    }
}
