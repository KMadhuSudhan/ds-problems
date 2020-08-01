package ds.problems.math;
//https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
//1523. Count Odd Numbers in an Interval Range

public class _1523CountOddNumbersInAnIntervalRange {

    public int countOdds(int low, int high) {
        if(low%2==0 && high%2==0)
        {
            return (high-low)/2;
        }
        return (high-low)/2 +1;
    }
}
