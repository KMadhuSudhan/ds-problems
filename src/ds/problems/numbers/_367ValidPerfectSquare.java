package ds.problems.numbers;
//https://leetcode.com/problems/valid-perfect-square/
//367. Valid Perfect Square

public class _367ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        if(num <= 0) return false;

        return find(num, 0, num);
    }

    boolean find(long tgt, int l, int h)
    {
        while(l <= h)
        {
            int mid = (l+h)/2;
            long sq = (long)mid*mid;
            if(sq == tgt) return true;
            else if(sq > tgt) h = mid-1;
            else l = mid+1;
        }
        return false;
    }
}
