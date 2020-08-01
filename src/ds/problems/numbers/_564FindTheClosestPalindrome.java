package ds.problems.numbers;
//https://leetcode.com/problems/find-the-closest-palindrome/
//564. Find the Closest Palindrome

public class _564FindTheClosestPalindrome {
    public static void main(String[] args) {
        _564FindTheClosestPalindrome findTheClosestPalindrome = new _564FindTheClosestPalindrome();
        findTheClosestPalindrome.nearestPalindromic("1234");
    }
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        long newNum = num;
        long largePalin = 0;
        long smallPalin = 0;
        long unit = 1;
        for (int i = 0; i < n.length() / 2 - 1; i++) unit *= 10;
        do {
            largePalin = makePalindrome(newNum += unit);
        } while (largePalin <= num);
        newNum = num;
        do {
            if (newNum < unit) break;
            smallPalin = makePalindrome(newNum -= unit);
        } while (smallPalin >= num);

        return num - smallPalin <= largePalin - num ? String.valueOf(smallPalin) : String.valueOf(largePalin);
    }

    long makePalindrome(long num) {
        char[] arr = String.valueOf(num).toCharArray();
        int head = 0, tail = arr.length - 1;
        while (head < tail) {
            arr[tail--] = arr[head++];
        }
        return Long.parseLong(new String(arr));
    }
}
