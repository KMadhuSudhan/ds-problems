package ds.problems.math;
//https://leetcode.com/problems/reach-a-number/
//754. Reach a Number

public class _754ReachANumber {
    public int reachNumber(int target) {
        target= Math.abs(target);
        int n=0;
        int count=0;
        while (count<target)
        {
            n++;
            count+=n;
        }

        if(count==target) return n;
        int k=count-target;
        if(k%2==0) return n;
        if((n+1)%2!=0) return n+1;
        return n+2;
    }
}
