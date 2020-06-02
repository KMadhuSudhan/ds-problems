package ds.problems.array;
//https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
//1413. Minimum Value to Get Positive Step by Step Sum

public class _1413MinimumValuetoGetPositiveStepbyStepSum {

    public int minStartValue(int[] nums) {
        int ans=1;
        int s=0;
        for(int i=0;i<nums.length;i++){
            s+=nums[i];
            if(s<0){
                ans=Math.max(ans,Math.abs(s)+1);
            }
        }
        return ans;
    }
}
