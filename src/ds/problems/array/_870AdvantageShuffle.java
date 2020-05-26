package ds.problems.array;

import java.util.Arrays;

public class _870AdvantageShuffle {

    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[] ans = new int[A.length];
        int n=0;
        for (int i=0;i<B.length;i++) {
            ans[n++] = search(A,B[i]);
        }
        return ans;
    }


    private int search(int[] A,int target) {
        if(target<A[0]) return 0;
        int low=0,high = A.length-1;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if(A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
