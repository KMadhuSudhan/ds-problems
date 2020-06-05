package ds.problems.array;
//https://leetcode.com/problems/relative-sort-array/
//1122. Relative Sort Array

public class _1122RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] countMap = new int[1001];
        for(int num: arr1) {
            countMap[num]++;
        }
        int index = 0;
        for(int num: arr2) {
            while(countMap[num]-- > 0 ) {
                arr1[index++] = num;
            }
        }
        for(int i=0;i<=1000;i++) {
            while(countMap[i] -- > 0 ) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }
}
