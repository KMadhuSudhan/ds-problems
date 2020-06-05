package ds.problems.array;
//https://leetcode.com/problems/sort-array-by-parity/
//905. Sort Array By Parity

public class _905SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        int low = 0,high = A.length-1;
        while(low<high) {
            while(high> low && A[high]%2 == 1) {
                high--;
            }

            while(low < high && A[low]%2 == 0) {
                low++;
            }
            if(high == low) break;
            int tmp = A[low];
            A[low] = A[high];
            A[high] = tmp;
        }
        return A;
    }
}
