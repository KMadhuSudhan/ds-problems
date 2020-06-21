package ds.problems.array;
//https://leetcode.com/problems/4sum-ii/
//454. 4Sum II

import java.util.HashMap;

public class _4544sumii {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;

        if(A != null && A.length != 0){
            int i, j, sum, N = A.length;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(i = 0; i < N; i++){
                for(j = 0; j < N; j++){
                    sum = A[i] + B[j];
                    map.put(sum, 1 + map.getOrDefault(sum, 0));
                }
            }

            for(i = 0; i < N; i++){
                for(j = 0; j < N; j++){
                    sum = C[i] + D[j];
                    count += map.getOrDefault(-sum, 0);
                }
            }
        }

        return count;
    }
}
