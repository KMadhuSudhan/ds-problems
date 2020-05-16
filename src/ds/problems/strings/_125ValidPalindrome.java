package ds.problems.strings;
//https://leetcode.com/problems/valid-palindrome/
//125. Valid Palindrome

public class _125ValidPalindrome {
    public static void main(String[] args) {
        _125ValidPalindrome palindrome = new _125ValidPalindrome();
        System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        if(chars.length == 0) return true;
        int low =0,high = chars.length-1;
        while (low<high) {
            while (low<high && !isAlphaNumeric(chars[low])) {
                low++;
            }
            while (high > low && !isAlphaNumeric(chars[high])) {
                high--;
            }
            if(low == high) return true;
            convertToLowerCase(chars,low);
            convertToLowerCase(chars,high);
            if(chars[low] !=chars[high]) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }


    boolean isAlphaNumeric(char character) {
        if(character>='0' && character<='9') {
            return true;
        }
        if(character>=65 && character<=90) {
            return true;
        }
        if(character>=97 && character<=122) {
            return true;
        }
        return false;
    }

    void  convertToLowerCase(char[] chars,int index ) {
        if(chars[index]<97) {
            chars[index] = (char) (chars[index] + 32);
        }
    }
}
