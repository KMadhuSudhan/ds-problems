package ds.problems.array;
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
//448. Find All Numbers Disappeared in an Array

import java.util.ArrayList;
import java.util.List;

public class _448FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        _448FindAllNumbersDisappearedInAnArray findAllNumbersDisappearedInAnArray = new _448FindAllNumbersDisappearedInAnArray();
        findAllNumbersDisappearedInAnArray.findDisappearedNumbers(nums);
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList();
        for(int i=0;i<nums.length;i++){
            int num = Math.abs(nums[i]);
            if(nums[num -1] > 0) {
                nums[num-1] = -nums[num-1] ;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) {
                result.add(i+1);
            }
        }
        return result;
    }
}
