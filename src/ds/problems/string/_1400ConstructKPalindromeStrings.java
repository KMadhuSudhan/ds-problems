package ds.problems.string;
//https://leetcode.com/problems/construct-k-palindrome-strings/
//1400. Construct K Palindrome Strings

public class _1400ConstructKPalindromeStrings {

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        char[] chars = s.toCharArray();
        int[] arr = new int[26];
        for(char c: chars) {
            arr[c - 'a']++;
        }
        int odd = 0;
        for(int i=0;i<26;i++) {
            if(arr[i]%2 == 1) {
                odd++;
            }
        }
        return odd<=k;
    }
}
