package ds.problems.array;
//https://leetcode.com/problems/majority-element/
//169. Majority Element

public class _169MajorityElement {

    public int majorityElement(int[] nums) {
        int majarity = 0,count = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == nums[majarity]) {
                count++;
            }  else {
                count--;
            }
            if(count == 0) {
                majarity = i;
                count = 1;
            }
        }
        return nums[majarity];
    }

}
