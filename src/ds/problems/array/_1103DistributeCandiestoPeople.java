package ds.problems.array;
//https://leetcode.com/problems/distribute-candies-to-people/
//1103. Distribute Candies to People

public class _1103DistributeCandiestoPeople {
    public static void main(String[] args) {
        _1103DistributeCandiestoPeople distributeCandiestoPeople = new _1103DistributeCandiestoPeople();
        System.out.println(distributeCandiestoPeople.distributeCandies(10,3));
    }
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i=0;
        while(candies > 0) {
            ans[i%num_people] += candies >= i+1 ? ++i : candies;
            candies = candies -i;
        }
        return ans;
    }
}
