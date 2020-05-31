package ds.problems.array;
//https://leetcode.com/problems/first-bad-version/
//278. First Bad Version

public class _278FirstBadVersion {
    public int firstBadVersion(int n) {
        int low = 1,high=n;
        while(low< high) {
            int mid = low + (high-low)/2;
            if(isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    public boolean isBadVersion(int n) {
        return true;
    }
}
