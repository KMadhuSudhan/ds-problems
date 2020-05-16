package ds.problems.array;
//https://leetcode.com/problems/find-all-duplicates-in-an-array/
//442. Find All Duplicates in an Array

import java.util.ArrayList;
import java.util.List;

public class _442FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        _442FindAllDuplicatesInAnArray findAllDuplicatesInAnArray = new _442FindAllDuplicatesInAnArray();
        System.out.println(findAllDuplicatesInAnArray.findDuplicates(nums));
    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList();
        for(int i=0;i<nums.length;i++){
            int num = Math.abs(nums[i]);
            if(nums[num -1] < 0) {
                result.add(num);
            } else {
                nums[num-1] = -nums[num-1] ;
            }
        }
        return result;
    }
}
