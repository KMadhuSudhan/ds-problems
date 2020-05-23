package ds.problems.string;
//https://leetcode.com/problems/palindromic-substrings/
//647. Palindromic Substrings

public class _647PalindromicSubstrings {
    public static void main(String[] args) {
        _647PalindromicSubstrings palindromicSubstrings = new _647PalindromicSubstrings();
        String str = "abc";
        palindromicSubstrings.countSubstrings(str);
    }

    public int countSubstrings(String s) {
        int count = 0;
        char[] schars = s.toCharArray();
        for (int i = 0; i < schars.length; i++) {
            count+= expandAroundCenter(schars, i, i);
            count+= expandAroundCenter(schars, i, i + 1);
        }
        return count;
    }

    int expandAroundCenter(char[] schars, int left, int right) {
        int size = 0;
        while (left >= 0 && right < schars.length && schars[left--] == schars[right++]) {
            size++;
        }
        return size;
    }
}
