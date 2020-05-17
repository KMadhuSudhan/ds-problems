package ds.problems.strings;
//https://leetcode.com/problems/reverse-string-ii/
//541. Reverse String II

public class _541ReverseStringII {
    public static void main(String[] args) {
        String s = "abcdefg";
        _541ReverseStringII reverseStringII = new _541ReverseStringII();
        System.out.println(reverseStringII.reverseStr(s,2));
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int start=0,end=k-1;
        if(k > chars.length){
            reverse(chars,0,chars.length-1);
            return new String(chars);
        }
        while(end < chars.length) {
            reverse(chars,start,end);
            start = start + 2*k;
            end = end + 2*k;
        }
        if(end>=chars.length) {
            end = chars.length-1;
        }
        reverse(chars,start,end);
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
