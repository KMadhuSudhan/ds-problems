package ds.problems.array;
//https://leetcode.com/problems/subarray-sums-divisible-by-k/
//974. Subarray Sums Divisible by K

public class _974SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] a, int k) {
        int[] ans=new int[k];
        ans[0]=1;
        int count=0, sum=0;
        for (int i:a){
            sum=(sum+i)%k;
            if (sum<0) sum+=k;
            count+=ans[sum];
            ans[sum]++;
        }
        return count;
    }
}
