package ds.problems.bits;
//https://leetcode.com/problems/total-hamming-distance/
//477. Total Hamming Distance

public class _477TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int res = 0, oneCount = 0;
        for (int i = 0; i < 32; i++) {
            oneCount = 0;
            for (int j = 0; j < n; j++) {
                oneCount += nums[j] >> i & 1;
            }
            res += oneCount * (n - oneCount);
        }
        return res;
    }
}
