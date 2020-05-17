package ds.problems.array;
//https://leetcode.com/problems/maximum-average-subarray-i/
//643. Maximum Average Subarray I

public class _643MaximumAverageSubarray {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        _643MaximumAverageSubarray maximumAverageSubarray = new _643MaximumAverageSubarray();
        System.out.println(maximumAverageSubarray.findMaxAverage(nums,4));
    }
    public double findMaxAverage(int[] nums, int k) {
        int sum =0,i=0,j=0;
        while (i<k) {
            sum+=nums[i];
            i++;
        }
        double maxAvg = (double) sum/k;
        for (i=k;i<nums.length;i++) {
            sum-=nums[j];
            sum+=nums[i];
            double avg = (double) sum/k;
            maxAvg = avg > maxAvg ? avg : maxAvg;
            j++;
        }
        return maxAvg;
    }
}
