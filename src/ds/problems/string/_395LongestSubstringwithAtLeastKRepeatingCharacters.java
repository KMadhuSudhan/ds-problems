package ds.problems.string;
//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
//395. Longest Substring with At Least K Repeating Characters

public class _395LongestSubstringwithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        if (s.length()==0)return 0;
        int [] a=new int [26];
        for (int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        int left=-1,right=s.length();
        int i=0,j=s.length()-1;
        while(i<=j){
            if (a[s.charAt(i)-'a']<k){
                while(left!=i){
                    a[s.charAt(++left)-'a']--;
                }
                i++;j=right-1;
            }else if (a[s.charAt(j)-'a']<k){
                while(right!=j){
                    a[s.charAt(--right)-'a']--;
                }
                j--;i=left+1;
            }else {
                i++;j--;
            }

        }

        return right-left-1;
    }
}
