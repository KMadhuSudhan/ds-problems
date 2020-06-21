package ds.problems.math;
//https://leetcode.com/problems/count-numbers-with-unique-digits/
//357. Count Numbers with Unique Digits

public class _357CountNumberswithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        // 0 ~ 9
        int res = 10;
        if (n > 1) {
            // more than two digits, first digit is 1 ~ 9, remaining digits could be 0 ~ 9 but not repeat with used digits.
            // so it's 9 * 9 * 8 * 7 * ...
            int uniqueDigits = 9;
            for (int i = 1; i < n; i++) {
                uniqueDigits *= (10 - i);
                res += uniqueDigits;
            }
        }
        return res;
    }
}


