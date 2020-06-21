package ds.problems.system.design;
//https://leetcode.com/problems/range-sum-query-immutable/
//303. Range Sum Query - Immutable

public class _303RangeSumQueryImmutable {
    int[] sum;
    int n;
    public _303RangeSumQueryImmutable(int[] nums) {
        n = nums.length;
        sum = new int[nums.length];
        if(n>0) {
            sum[0] = nums[0];
            for(int i=1;i<nums.length;i++) {
                sum[i] = sum[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if(n == 0) return 0;
        if(i ==0) {
            return sum[j];
        } else {
            return sum[j] - sum[i-1];
        }
    }
}
