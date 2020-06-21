package ds.problems.array;
//https://leetcode.com/problems/the-k-strongest-values-in-an-array/
//1471. The k Strongest Values in an Array

import java.util.Arrays;

public class _1471TheKStrongestValuesInAarray {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = (arr.length -1)/2;
        int i=0,j=arr.length -1;
        int[] ans = new int[k];
        int x = 0;
        while(i<=j && k>0){
            int iVal = Math.abs(arr[i] - arr[m]);
            int jVal = Math.abs(arr[j] - arr[m]);
            if(iVal <= jVal) {
                ans[x++] = arr[j];
                j--;
            } else {
                ans[x++] = arr[i];
                i++;
            }
            k--;
        }
        return ans;
    }
}
