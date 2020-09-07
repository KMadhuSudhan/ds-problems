package ds.problems.array;
//https://leetcode.com/problems/three-consecutive-odds/
//1550. Three Consecutive Odds

public class _1550ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0;i<arr.length-2;i++) {
            if(arr[i]%2 == 1 && arr[i+1]%2 ==1 && arr[i+2]%2 == 1) return true;
        }
        return false;
    }
}
