package ds.problems.strings;
//https://leetcode.com/problems/reverse-words-in-a-string-iii/
//557. Reverse Words in a String III

public class _557ReverseWordsInAStringIII {
    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        _557ReverseWordsInAStringIII reverseWordsInAStringIII = new _557ReverseWordsInAStringIII();
        System.out.println(reverseWordsInAStringIII.reverseWords(str));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0,end = 0;
        while(end<chars.length) {
            while(end < chars.length && chars[end] != ' '){
                end++;
            }

            if(end == chars.length) {
                end = chars.length-1;
                reverse(chars,start,end);
                break;
            } else {
                end--;
                reverse(chars,start,end);
                end+=2;
            }
            start = end;
        }
        return new String(chars);
    }

    public void reverse(char[] chars,int low,int high) {
        while (low<high) {
            char tmp = chars[low];
            chars[low] = chars[high];
            chars[high] = tmp;
            low++;
            high--;
        }
    }
}
