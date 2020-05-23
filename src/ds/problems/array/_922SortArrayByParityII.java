package ds.problems.array;
//https://leetcode.com/problems/sort-array-by-parity-ii/
//922. Sort Array By Parity II

public class _922SortArrayByParityII {
    public static void main(String[] args) {
        int[] nums = {4,2,5,7};
        _922SortArrayByParityII sortArrayByParityII = new _922SortArrayByParityII();
        sortArrayByParityII.sortArrayByParityII(nums);
    }
    public int[] sortArrayByParityII(int[] A) {
        int e=0,o=1;
        while(o<A.length) {
            while(e < A.length && A[e]%2 == 0) e+=2;
            while(o < A.length && A[o]%2 == 1) o+=2;
            if(o >= A.length) return A;
            int tmp = A[e];
            A[e] = A[o];
            A[o] = tmp;
        }
        return A;
    }
}
