package ds.problems.numbers;

public class _9PalindromeNumber {
    public static void main(String[] args) {
        _9PalindromeNumber palindromeNumber = new _9PalindromeNumber();
        palindromeNumber.isPalindrome(-121);
    }
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        return x == reverse(x);
    }

    int reverse(int n) {
        int reversedNum = 0;
        while(n!=0) {
            reversedNum = reversedNum*10 + n%10;
            n/=10;
        }
        return reversedNum;
    }
}
