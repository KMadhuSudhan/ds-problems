package ds.problems.string;
//https://leetcode.com/problems/permutation-in-string/
//567. Permutation in String

public class _567PermutationInString {

    public boolean checkInclusion(String p, String s) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        int[] map = new int[26];
        int i,j;
        for(i=0;i<pChars.length;i++) {
            map[pChars[i] - 'a']++;
        }
        i = 0;
        j=0;
        while(i<sChars.length) {
            // valid anagram
            if(map[s.charAt(i) - 'a'] > 0){
                map[s.charAt(i++) - 'a']--;
                // window size equal to size of P
                if(i-j ==  p.length()){
                    return true;
                }
            }
            // window is of size 0
            else if(i == j){
                i ++;
                j ++;
            }
            // decrease window size
            else{
                map[s.charAt(j++) - 'a']++;
            }
        }
        return false;
    }
}
