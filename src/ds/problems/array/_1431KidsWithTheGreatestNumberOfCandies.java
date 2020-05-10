package ds.problems.array;
//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
//1431. Kids With the Greatest Number of Candies

import java.util.ArrayList;
import java.util.List;

public class _1431KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        _1431KidsWithTheGreatestNumberOfCandies candies = new _1431KidsWithTheGreatestNumberOfCandies();
        int[] nums = {2,3,5,1,3};
        System.out.println(candies.kidsWithCandies(nums,3));
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++) {
            max = Math.max(max,candies[i]);
        }
        List<Boolean> ans = new ArrayList();
        for(int i=0;i<candies.length;i++) {
            ans.add(candies[i] + extraCandies >= max);
        }
        return ans;
    }
}
