package ds.problems.array;
//https://leetcode.com/problems/number-of-good-pairs/
//1512. Number of Good Pairs

public class _1512NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        int value = 0;
        int[] arr = new int[101];
        for (int i = 0; i < nums.length; i++) {
            value = value + arr[nums[i]];
            arr[nums[i]]++;
        }
        return value;
    }
    //c(n,2) => n!/(n-2)!2! => n*n-1/2;
    public int numIdenticalPairsWithCn2(int[] nums) {
        int ans = 0;
        int count[] = new int[101];
        for(int num : nums) count[num]++;
        for(int num : count){
            if(num > 0){
                ans += (num * (num - 1))/2;
            }
        }
        return ans;
    }
}
