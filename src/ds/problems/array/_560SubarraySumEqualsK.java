package ds.problems.array;
//https://leetcode.com/problems/subarray-sum-equals-k/
//560. Subarray Sum Equals K

import java.util.HashMap;
import java.util.Map;

public class _560SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        _560SubarraySumEqualsK subarraySumEqualsK = new _560SubarraySumEqualsK();
        subarraySumEqualsK.subarraySum(nums,2);
    }
    public int subarraySum(int[] nums, int k) {
        int j=0,count=0,sum=0;
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            count+= map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
