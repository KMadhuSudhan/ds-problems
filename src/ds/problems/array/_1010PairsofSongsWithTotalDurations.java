package ds.problems.array;
//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
//1010. Pairs of Songs With Total Durations Divisible by 60


public class _1010PairsofSongsWithTotalDurations {
    public static void main(String[] args) {
        _1010PairsofSongsWithTotalDurations pairsofSongsWithTotalDurations = new _1010PairsofSongsWithTotalDurations();
        int[] nums = {60,60,60};
        System.out.println(pairsofSongsWithTotalDurations.numPairsDivisibleBy60(nums));
    }
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] map = new int[61];
        for(int i=0;i<time.length;i++) {
            int r = time[i]%60;
            int key = 60 - r;
            count += map[key%60];
            map[r]++;
        }
        return count;
    }
}
