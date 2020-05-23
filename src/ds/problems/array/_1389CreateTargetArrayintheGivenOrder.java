package ds.problems.array;
//https://leetcode.com/problems/create-target-array-in-the-given-order/
//1389. Create Target Array in the Given Order

import java.util.ArrayList;
import java.util.List;

public class _1389CreateTargetArrayintheGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList();
        for(int i=0;i<nums.length;i++) {
            list.add(index[i],nums[i]);
        }
        int[] ans = new int[list.size()];
        int i=0;
        for(int num: list) {
            ans[i++] = num;
        }
        return ans;
    }
}
