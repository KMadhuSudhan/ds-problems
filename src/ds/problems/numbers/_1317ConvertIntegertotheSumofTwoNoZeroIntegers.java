package ds.problems.numbers;

public class _1317ConvertIntegertotheSumofTwoNoZeroIntegers {

    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for(int i = 1;i<n;i++){
            if(!containsZero(i) && !containsZero(n-i))
                return new int[]{i, n-i};
        }
        return ans;
    }
    boolean containsZero(int n) {
        while(n!=0) {
            int r = n%10;
            if(r == 0 ) return true;
            n/=10;
        }
        return false;
    }
}
