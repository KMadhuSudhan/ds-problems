package ds.problems.strings;
//https://leetcode.com/problems/reverse-vowels-of-a-string/
//345. Reverse Vowels of a String

public class _345ReverseVowelsOfAString {
    public static void main(String[] args) {
        _345ReverseVowelsOfAString reverseVowelsOfAString = new _345ReverseVowelsOfAString();
        reverseVowelsOfAString.reverseVowels("hello");
    }
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int low = 0,high = chars.length -1;
        while(low<high) {
            while(low<high && !isVowel(chars[low])) {
                low++;
            }
            while(high > low && !isVowel(chars[high])) {
                high--;
            }
            if(high == low) {
                return new String(chars);
            }
            swap(chars,low,high);
            low++;
            high--;
        }
        return new String(chars);
    }
    void swap(char[] chars,int i,int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
    boolean isVowel(char character) {
        switch(character) {
            case 'a':
                return true;
            case 'e':
                return true;
            case 'i':
                return true;
            case 'o':
                return true;
            case 'u':
                return true;
            case 'A':
                return true;
            case 'E':
                return true;
            case 'I':
                return true;
            case 'O':
                return true;
            case 'U':
                return true;
        }
        return false;
    }
}
