package ds.problems.array;
//https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
//1574. Shortest Subarray to be Removed to Make Array Sorted

public class _1574ShortestSubarrayToBeRemovedToMakeArraySorted {
    public static void main(String[] args) {
        _1574ShortestSubarrayToBeRemovedToMakeArraySorted  sorted = new _1574ShortestSubarrayToBeRemovedToMakeArraySorted();
        int[] arr = new int[]{1,2,3,10,4,2,3,5};
        sorted.findLengthOfShortestSubarray(arr);
    }
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length,left = 0,right = arr.length - 1;
        while(left+1<n && arr[left] <= arr[left+1]) {
            left++;
        }
        if(left == n-1) return 0;
        while(right>left && arr[right] >= arr[right-1]) {
            right--;
        }
        int i=0,j = right;
        int ans = Math.min(n-left-1,right);
        while(j<n && i<=left) {
            if(arr[j]>= arr[i]) {
                ans = Math.min(ans,j-i-1);
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}
