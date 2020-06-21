package ds.problems.bits;
//https://leetcode.com/problems/convert-a-number-to-hexadecimal/
//405. Convert a Number to Hexadecimal

public class _405ConvertaNumbertoHexadecimal {

    public String toHex(int num) {
        if(num==0) return "0";
        char[] itoh=new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();
        long n = (int)num;
        if(n<0) n+=4294967296L;
        while(n!=0){
            long mod = n%16;
            n /= 16;
            sb.append(itoh[(int)mod]);
        }
        return sb.reverse().toString();
    }
}
