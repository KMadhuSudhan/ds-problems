package ds.problems.math;

public class _1390FourDivisors {

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum += isFourDivisors(nums[i]);
        }
        return sum;
    }
    int isFourDivisors(int n) {
        int count=0,sum=0;
        int sqrt = (int) Math.sqrt(n);
        if(sqrt*sqrt == n) {
            count++;
            sum+=sqrt;
        }
        for(int i=1;i<=sqrt;i++) {
            if(n%i == 0) {
                count+=2;
                sum+=i + n/i;
            }
            if(count > 4) return 0;
        }
        if(count<4) return 0;
        return sum;
    }
}
