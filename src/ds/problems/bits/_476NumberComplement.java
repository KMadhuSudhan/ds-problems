package ds.problems.bits;
//https://leetcode.com/problems/number-complement/
//476. Number Complement

public class _476NumberComplement {

    public int findComplement(int num) {
        int res = 0;
        int m = 1;
        while (num != 0) {
            if ((num & 1) == 0) {
                res += m;
            }
            m = m << 1;
            num = num >> 1;
        }
        return res;
    }
}
