package ds.problems.numbers;
//https://leetcode.com/problems/ugly-number/submissions/
//263. Ugly Number

public class _263UglyNumber {

    public static void main(String[] args) {
        _263UglyNumber uglyNumber = new _263UglyNumber();
        System.out.println(uglyNumber.isUgly(6));
    }

    public boolean isUgly(int num) {
        if (num == 1) return true;
        while (true) {
            int tmp = num;
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            }
            if(tmp == num) return false;
            if(num == 1) return true;
        }
    }
}
