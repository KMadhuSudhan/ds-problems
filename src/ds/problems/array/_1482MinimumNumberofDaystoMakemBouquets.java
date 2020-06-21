package ds.problems.array;
//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
//1482. Minimum Number of Days to Make m Bouquets

public class _1482MinimumNumberofDaystoMakemBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE,high = Integer.MIN_VALUE;
        if(m*k > bloomDay.length) return -1;
        for(int i=0;i<bloomDay.length;i++) {
            low = Math.min(low,bloomDay[i]);
            high = Math.max(high,bloomDay[i]);
        }
        while(low<=high) {
            int mid = low + (high - low)/2;
            if(isValid(bloomDay,mid,m,k)) {
                high = mid -1;
            } else {
                low = mid  +1;
            }
        }
        return low;
    }

    boolean isValid(int[] bloomDay,int mid, int m, int k) {
        int size = 0,count = 0;
        for(int i=0;i<bloomDay.length;i++) {
            size = bloomDay[i] <= mid ? size  +1 : 0;
            if(size == k) {
                size = 0;
                count++;
            }
            if(count == m) return true;
        }
        return false;
    }
}
