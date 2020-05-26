package ds.problems.array;
//https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
//1304. Find N Unique Integers Sum up to Zero

public class _1304FindnUniqueIntegersSumuptozero {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int count =0;
        if(n%2==1) {
            ans[count++] = 0;
            while(count<n) {
                int num = count;
                ans[count++] = num;
                ans[count++] = -num;
            }
        } else {
            count = 1;
            while(count<=n) {
                int num = count;
                ans[count++-1] = num;
                ans[count++-1] = -num;
            }
        }
        return ans;
    }
}
