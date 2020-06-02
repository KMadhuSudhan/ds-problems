package ds.problems.math;
//https://leetcode.com/problems/maximum-69-number/
//1323. Maximum 69 Number

public class _1323Maximum69Number {

    public int maximum69Number (int num) {
        String number = Integer.toString(num);
        char[] chars = number.toCharArray();
        int i=0;
        while(i < chars.length && chars[i] != '6') {
            i++;
        }
        if(i == chars.length) {
            return Integer.parseInt(new String(chars));
        }
        chars[i] = '9';
        return Integer.parseInt(new String(chars));
    }
}
