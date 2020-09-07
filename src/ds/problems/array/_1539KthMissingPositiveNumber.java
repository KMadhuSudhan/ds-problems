package ds.problems.array;
//https://leetcode.com/problems/kth-missing-positive-number/
//1539. Kth Missing Positive Number

public class _1539KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        int count= 0,i=1, missing = 0,j=0;
        while(count<k && j<arr.length) {
            if(arr[j]!=i) {
                count++;
                missing = i;
                i++;
            } else {
                i++;
                j++;
            }
        }
        int max = arr[arr.length-1];
        if(count < k) {
            return max + (k - count);
        }
        return missing;
    }

    //binary search
//    public int findKthPositive(int[] arr, int k) {
//        int l = 0, r = arr.length;
//        while (l < r) {
//            int mid = l + (r - l) / 2;
//            if (arr[mid] - (mid + 1) >= k) r = mid;  //missed more or equal than k numbers, left side;
//            else l = mid + 1;   // missed less than k numbers, must be in the right side;
//        }
//        return l + k;
//    }

}
