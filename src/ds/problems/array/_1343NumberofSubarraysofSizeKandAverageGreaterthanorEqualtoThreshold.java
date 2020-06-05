package ds.problems.array;
//https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
//1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

public class _1343NumberofSubarraysofSizeKandAverageGreaterthanorEqualtoThreshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i=0,sum =0,count = 0,j=0;
        while(i < arr.length && i<k) {
            sum+=arr[i];
            i++;
        }
        if(sum/k >=threshold ) {
            count++;
        }
        while(i<arr.length) {
            sum-=arr[j];
            sum+=arr[i];
            if(sum/k >=threshold ) {
                count++;
            }
            i++;
            j++;
        }
        return count;
    }
}
