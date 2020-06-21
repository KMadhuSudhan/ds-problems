package ds.problems.bits;

public class _1009ComplementofBase {
    public int bitwiseComplement(int N) {
        int result = 0, i = 0;

        if (N==0) return 1;

        while(N>0){
            int b = N%2;
            result +=(int) ((b==0 ? 1:0)* Math.pow(2,i));
            N/=2;
            i++;
        }

        return result;
    }
}
