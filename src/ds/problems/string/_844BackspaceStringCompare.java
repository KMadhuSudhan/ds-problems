package ds.problems.string;
//https://leetcode.com/problems/backspace-string-compare/
//844. Backspace String Compare

public class _844BackspaceStringCompare {
    public static void main(String[] args) {
        _844BackspaceStringCompare backspaceStringCompare = new _844BackspaceStringCompare();
        System.out.println(backspaceStringCompare.backspaceCompare("aaa###a","aaaa###a"));
    }
    public boolean backspaceCompare(String s, String t) {
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        int i = s.length()-1, j = t.length()-1;
        int countS =0, countT=0;
        while(i>=0||j>=0){
            if(i>=0&&S[i]=='#') {
                countS++;
                i--;
            }
            else if(j>=0&&T[j]=='#') {
                countT++;
                j--;
            }
            else if(countS>0) {
                i--;
                countS--;
            }
            else if(countT>0){
                j--;
                countT--;
            }
            else if(i>=0&&j>=0)
            {
                if(S[i]==T[j]) {
                    i--;
                    j--;
                }
                else return false;
            }
            else return false;
        }
        return true;
    }
}
