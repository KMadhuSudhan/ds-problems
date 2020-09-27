package ds.problems.bits;
//https://leetcode.com/problems/flip-string-to-monotone-increasing/
//926. Flip String to Monotone Increasing

public class _926FilfStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        int cur = 0;

        for(int i=0; i<S.length(); i++)
            if(S.charAt(i) == '1')
                cur++;
        int min=cur;

        for(int i=0; i<S.length(); i++)
        {
            int pos = S.length()-1-i;
            if(S.charAt(pos)=='0')
                cur+=1;
            else
                cur-=1;

            if(cur<min)
                min=cur;
        }

        return min;
    }
}
