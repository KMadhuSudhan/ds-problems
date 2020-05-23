package ds.problems.numbers;
//https://leetcode.com/problems/sqrtx/
//69. Sqrt(x)

public class _69SqureRootOfX {

    public int mySqrt(int x) {
        if(x == 1) return 1;

        return find(x, 1, x/2);
    }
    int find(int tgt, int l, int h)
    {
        while(l <= h)
        {
            int mid = (l+h)/2;
            int num = tgt/mid;
            if(num == mid) return mid;
            else if(num < mid) h = mid-1;
            else l = mid+1;
        }
        return h;
    }
}
