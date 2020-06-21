package ds.problems.string;
//https://leetcode.com/problems/valid-palindrome-ii
//680. Valid Palindrome II
public class _680ValidPalindromeII {

    public boolean validPalindrome(String s) {
        return helper(s, 1, 0, s.length() - 1);
    }

    private boolean helper(String s, int lives, int left, int right) {
        if (left == right) return true;
        if (left > right) return true;

        if (s.charAt(left) != s.charAt(right)) {
            if (lives <= 0) return false;
            return  helper(s, lives - 1, left + 1, right) || helper(s, lives - 1, left, right - 1);
        }

        return helper(s, lives, left + 1, right - 1);
    }
}
