package ds.problems.strings;
//https://leetcode.com/problems/reverse-string/
//344. Reverse String

public class _344ReverseString {
    public static void main(String[] args) {
        char[] chars = {'h','e','l','l','o'};
        _344ReverseString reverseString =  new  _344ReverseString();
        reverseString.reverseString(chars);
    }
    public void reverseString(char[] s) {
        int low=0,high = s.length -1;
        while(low<high) {
            char tmp = s[low];
            s[low] = s[high];
            s[high] = tmp;
            low++;
            high--;
        }
    }
}
