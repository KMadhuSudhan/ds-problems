package ds.problems.array;
//https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
//1287. Element Appearing More Than 25% In Sorted Array

public class _1287ElementAppearingMoreThanSortedArray {
    public int findSpecialInteger(int[] arr) {
        int i=0;
        int moreCount = arr.length/4;
        while(i<arr.length) {
            if(arr[i] == arr[i+moreCount]) {
                return arr[i];
            }
            i++;
        }
        return -1;
    }
}
