package ds.problems.bits;
//https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
//762. Prime Number of Set Bits in Binary Representation

public class _762PrimeNumberSetBitsBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        int res=0;
        for(int i=L; i<=R; ++i){
            if(isPrimeSetNumber(i))
                res++;
        }
        return res;
    }
    public boolean isPrimeSetNumber(int num){
        int count=0;
        while(num>0){
            if((num&1) == 1)
                count++;
            num = num>>1;
        }
        return isPrime(count);
    }
    public boolean isPrime(int num){
        if(num <=1) return false;
        for(int i=2; i<=num/2; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
