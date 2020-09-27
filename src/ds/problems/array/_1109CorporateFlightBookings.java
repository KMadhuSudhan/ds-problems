package ds.problems.array;
//https://leetcode.com/problems/corporate-flight-bookings/
//1109. Corporate Flight Bookings

public class _1109CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for(int[] booking: bookings) {
            int k = booking[2];
            int j = booking[1];
            int i = booking[0];
            if(j == n) {
                ans[i-1]+=k;
            } else {
                ans[i-1]+=k;
                ans[j]-=k;
            }
        }
        for(int i=1;i<ans.length;i++) {
            ans[i]+=ans[i-1];
        }
        return ans;
    }
}
