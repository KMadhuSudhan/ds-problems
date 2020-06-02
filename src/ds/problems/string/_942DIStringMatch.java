package ds.problems.string;
//https://leetcode.com/problems/di-string-match/
//942. DI String Match

public class _942DIStringMatch {

    public int[] diStringMatch(String S) {
        char[] chars = S.toCharArray();
        int high = chars.length,low=0;
        int[] ans = new int[high+1];
        for(int i=0;i<chars.length;i++) {
            if(chars[i] == 'I') {
                ans[i] = low++;
            } else {
                ans[i] = high--;
            }
        }
        ans[chars.length] = high;
        return ans;
    }
}
