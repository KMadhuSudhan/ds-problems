package ds.problems.array;
//https://leetcode.com/problems/binary-subarrays-with-sum/
//930. Binary Subarrays With Sum

import java.util.HashMap;
import java.util.Map;

public class _930BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        _930BinarySubarraysWithSum binarySubarraysWithSum = new _930BinarySubarraysWithSum();
        binarySubarraysWithSum.numSubarraysWithSum(nums,2);
    }

    public int numSubarraysWithSum(int[] A, int S) {
        int length = A.length;
        if(length == 0) return 0;
        int sum= A[0],count = 0,low = 0,high =1;
        while (high<length) {
            while(high<length && sum < S) {
                sum+=A[high++];
            }
            //expand array to right if following zeros present
            if(sum == S) {
                int j = high;
                while(j<length && A[j] == 0) {
                    j++;
                }
                count += j - high + 1;
            }
            sum-=A[low++];
            while(low>=high) {
                sum+=A[high++];
            }
        }
        while (low<high && sum == S) {
            count++;
            sum-=A[low++];
        }
        return count;
    }

    public int numSubarraysWithSumPrefixSum(int[] A, int S) {
        int sum=0,ans =0;
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for(int x: A) {
            sum+=x;
            ans+=map.getOrDefault(sum - S,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
