package ds.problems.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/majority-element-ii/
//229. Majority Element II
public class _299MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int N = nums.length;

        Set<Integer> majority = new HashSet();
        if(N == 1){
            majority.add(nums[0]);
        }else if(N == 2){
            if(nums[0] != nums[1]){
                majority.add(nums[0]);
                majority.add(nums[1]);
            }else
                majority.add(nums[0]);
        }else if(N > 2){
            int x = getMajority(nums, 0, N/3);
            int y = getMajority(nums, (N/3), (2*N)/3);
            int z = getMajority(nums, ((2*N)/3), N);

            if(isOneThirdMajority(nums, N, x))
                majority.add(x);

            if(isOneThirdMajority(nums, N, y))
                majority.add(y);

            if(isOneThirdMajority(nums, N, z))
                majority.add(z);

            x = getMajorityReverse(nums, 0, N/3);
            y = getMajorityReverse(nums, (N/3), (2*N)/3);
            z = getMajorityReverse(nums, ((2*N)/3), N);

            if(isOneThirdMajority(nums, N, x))
                majority.add(x);

            if(isOneThirdMajority(nums, N, y))
                majority.add(y);

            if(isOneThirdMajority(nums, N, z))
                majority.add(z);
        }
        return  new ArrayList(majority);
    }

    private boolean isOneThirdMajority(int[] nums, int N, int x){
        int count = 0;
        for(int i = 0; i < N; i++){
            if(nums[i] == x)
                ++count;
        }

        return (count > (N/3));
    }

    private int getMajority(int[] nums, int start, int end){
        int x = nums[start];
        int votes = 0;

        for(int i = start; i < end; i++){
            if(votes == 0)
                x = nums[i];

            if(nums[i] == x)
                ++votes;
            else
                --votes;
        }

        return x;
    }

    private int getMajorityReverse(int[] nums, int start, int end){
        int x = nums[start];
        int votes = 0;

        for(int i = end - 1; i >= start; i--){
            if(votes == 0)
                x = nums[i];

            if(nums[i] == x)
                ++votes;
            else
                --votes;
        }
        return x;
    }
}
