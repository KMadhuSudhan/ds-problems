package ds.problems.array;
//https://leetcode.com/problems/guess-number-higher-or-lower/
//374. Guess Number Higher or Lower

public class _374GuessNumberHigherorLower {

    public int guessNumber(int n) {
        int low=1,high=n;
        while(low<high) {
            int mid = low + (high-low)/2;
            if(guess(mid) == 0) {
                return mid;
            }
            if(guess(mid) == -1) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return high;
    }

    int guess(int n) {
        return 0;
    }
}
