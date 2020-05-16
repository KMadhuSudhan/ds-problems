package ds.problems.numbers;
//https://leetcode.com/problems/add-digits/
//258. Add Digits

public class _258AddDigits {
    public static void main(String[] args) {
        _258AddDigits addDigits = new _258AddDigits();
        System.out.println(addDigits.addDigits(38));
    }
    public int addDigits(int num) {
        int digits = add(num);
        while(digits>9) {
            digits = add(digits);
        }
        return digits;
    }

    public int add(int num) {
        int sum = 0;
        while(num!=0) {
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
