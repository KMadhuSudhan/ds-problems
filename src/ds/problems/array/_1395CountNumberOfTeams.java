package ds.problems.array;
//https://leetcode.com/problems/count-number-of-teams/
//1395. Count Number of Teams

public class _1395CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int n = rating.length;

        int a = 0;
        int b = 0;
        int c = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            a = rating[i];
            for (int k = i+1; k < n; k++) {
                b = rating[k];
                for (int h = k+1; h < n; h++) {
                    c = rating[h];

                    if (a < b && b < c)
                    {
                        count++;
                        // System.out.println(a + " < " + b + " < " + c);
                    }
                    if (a > b && b > c)
                    {
                        count++;
                        // System.out.println(a + " > " + b + " > " + c);
                    }
                }
            }
        }

        return count;
    }
}
