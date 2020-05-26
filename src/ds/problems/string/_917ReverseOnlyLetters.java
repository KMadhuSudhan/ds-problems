package ds.problems.string;
//https://leetcode.com/problems/reverse-only-letters/
//917. Reverse Only Letters

public class _917ReverseOnlyLetters {

    public static void main(String[] args) {
        String str = "a-bC-dEf-ghIj";
        _917ReverseOnlyLetters reverseOnlyLetters = new _917ReverseOnlyLetters();
        System.out.println(reverseOnlyLetters.reverseOnlyLetters(str));
    }
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int low = 0,high = chars.length-1;
        while (low<high) {
            while(low<high && !isLetter(chars[low])) {
                low++;
            }
            while(high > low && !isLetter(chars[high])) {
                high--;
            }
            if(high == low) break;
            swap(chars,low,high);
            low++;
            high--;
        }
        return new String(chars);
    }

    void swap(char[] chars,int i,int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    boolean isLetter(char character) {
        return character>=65 && character<=90 || character>=97 && character<=122;
    }
}
