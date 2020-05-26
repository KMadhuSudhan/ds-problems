package ds.problems.numbers;
//https://leetcode.com/problems/reverse-integer/
//7. Reverse Integer

public class _7ReverseInteger {

    public int reverse(int x) {
        int num =0;
        while(x!=0) {
            if (num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && x > Integer.MAX_VALUE%10)) return 0;
            if (num < Integer.MIN_VALUE/10 || (num == Integer.MIN_VALUE/10 && x < Integer.MIN_VALUE%10)) return 0;
            num = num*10 + x % 10;
            x/=10;
        }
        return num;
    }
}
