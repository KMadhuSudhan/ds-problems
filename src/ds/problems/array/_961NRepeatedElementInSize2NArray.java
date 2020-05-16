package ds.problems.array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
//961. N-Repeated Element in Size 2N Array

public class _961NRepeatedElementInSize2NArray {
    public static void main(String[] args) {
        _961NRepeatedElementInSize2NArray repeatedElementInSize2NArray = new _961NRepeatedElementInSize2NArray();
        int[] nums = {1,2,3,3};
        repeatedElementInSize2NArray.repeatedNTimes(nums);
    }
    public int repeatedNTimes(int[] A) {
        for (int k = 1; k <= 3; ++k)
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i+k])
                    return A[i];

        throw null;
    }

    public int repeatedNTimesMap(int[] A) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<A.length;i++) {
            int freq = map.getOrDefault(A[i],0);
            freq++;
            map.put(A[i],freq);
            if(freq == A.length/2) return A[i];
        }
        return -1;
    }
}
