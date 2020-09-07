package ds.problems.array;
//https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
//1437. Check If All 1's Are at Least Length K Places Away

public class _1437CheckIfAllOnesAreAtLeastLengthKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int prevIndex = -(nums.length+1);
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 1) {
                if(i - prevIndex <= k) {
                    return false;
                }
                prevIndex = i;
            }
        }
        return true;
    }
}
